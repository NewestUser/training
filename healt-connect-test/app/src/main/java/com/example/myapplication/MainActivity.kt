package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.health.connect.client.records.WeightRecord
import androidx.health.connect.client.records.metadata.Metadata
import androidx.health.connect.client.units.kilograms
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch
import java.time.ZonedDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WriteWeightButton()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun WriteWeightButton() {
    val c = LocalContext.current
    val scope = rememberCoroutineScope()
    val client = HealthConnectUtil.getClient(c)

    val permissionsLauncher =
        rememberLauncherForActivityResult(HealthConnectUtil.requestPermissionActivityContract) { granted ->
            if (granted.containsAll(HealthConnectUtil.PERMISSIONS)) {
                scope.launch {
                    val time = ZonedDateTime.parse("2024-03-16T00:00:00+02:00[Europe/Sofia]")

                    val r = WeightRecord(
                        time = time.toInstant(),
                        zoneOffset = time.offset,
                        weight = 60.kilograms,
                        metadata = Metadata(
                            clientRecordId = "weight_dummy_id", clientRecordVersion = 0
                        )
                    )
                    val insertRecords = client.insertRecords(listOf(r))
                    println(insertRecords)
                }
            } else {
                Toast.makeText(c, "didn't get permissions", Toast.LENGTH_LONG).show()
            }
        }

    Button(onClick = {

        scope.launch {
            val perm = HealthConnectUtil.getGrantedPermissions(client)
            if (!perm.contains("android.permission.health.WRITE_WEIGHT")) {
                Toast.makeText(c, "can't insert weight, no perm", Toast.LENGTH_LONG).show()
                permissionsLauncher.launch(HealthConnectUtil.PERMISSIONS)
            } else {
                val time = ZonedDateTime.parse("2024-03-16T00:00:00+02:00[Europe/Sofia]")

                val r = WeightRecord(
                    time = time.toInstant(),
                    zoneOffset = time.offset,
                    weight = 66.kilograms,
                    metadata = Metadata(
                        clientRecordId = "weight_dummy_id", clientRecordVersion = 0
                    )
                )
                val insertRecords = client.insertRecords(listOf(r))
                println(insertRecords)
            }
        }


    }) {
        Text(text = "Write weight")

    }
}
