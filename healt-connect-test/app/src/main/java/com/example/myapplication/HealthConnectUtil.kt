package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.PermissionController
import androidx.health.connect.client.permission.HealthPermission
import androidx.health.connect.client.records.Record
import androidx.health.connect.client.records.WeightRecord
import kotlin.reflect.KClass

/**
 * https://developer.android.com/guide/health-and-fitness/health-connect/get-started
 */
object HealthConnectUtil {

    private const val providerPackageName = "com.google.android.apps.healthdata"

    // Create the permissions launcher.
    val requestPermissionActivityContract =
        PermissionController.createRequestPermissionResultContract()

    val PERMISSIONS =
        setOf(
//            HealthPermission.getReadPermission(WeightRecord::class),
            HealthPermission.getWritePermission(WeightRecord::class),
        )

    fun <T : Record> isWritePermissionGranted(
        permissions: Set<String>,
        kClass: KClass<T>
    ): Boolean {
        return permissions.contains(HealthPermission.getWritePermission(kClass))
    }

    suspend fun isAnyPermissionGranted(client: HealthConnectClient): Boolean {
        for (grantedPermission in getGrantedPermissions(client)) {
            if (PERMISSIONS.contains(grantedPermission)) {
                return true
            }
        }
        return false
    }

    suspend fun getGrantedPermissions(client: HealthConnectClient) =
        client.permissionController.getGrantedPermissions()

    fun requestPermissions(permissionsLauncher: ActivityResultLauncher<Set<String>>) {
        permissionsLauncher.launch(PERMISSIONS)
    }

    suspend fun revokePermissions(client: HealthConnectClient) {
        client.permissionController.revokeAllPermissions()
    }

//    fun registerForPermissionsResult(
//        context: Context,
//        onPermissionsGranted: (Set<String>) -> Unit,
//        onPermissionsDenied: () -> Unit,
//    ): ActivityResultLauncher<Set<String>> {
//        rememberLauncherForActivityResult(requestPermissionActivityContract) { granted ->
//            if (granted.containsAll(PERMISSIONS)) {
//                onPermissionsGranted.invoke(granted)
//            } else {
//                onPermissionsDenied.invoke()
//            }
//        }
//    }

    fun isHealthConnectUnsupported(context: Context): Boolean {
        val availabilityStatus = HealthConnectClient.getSdkStatus(context, providerPackageName)
        return availabilityStatus == HealthConnectClient.SDK_UNAVAILABLE
    }

    fun isHealthConnectInstallable(context: Context): Boolean {
        val availabilityStatus = HealthConnectClient.getSdkStatus(context, providerPackageName)
        return availabilityStatus == HealthConnectClient.SDK_UNAVAILABLE_PROVIDER_UPDATE_REQUIRED
    }

    fun isHealthConnectInstalled(context: Context): Boolean {
        val availabilityStatus = HealthConnectClient.getSdkStatus(context, providerPackageName)
        return availabilityStatus == HealthConnectClient.SDK_AVAILABLE
    }

    fun promptHealthConnectInstall(context: Context) {
        val uriString =
            "market://details?id=$providerPackageName&url=healthconnect%3A%2F%2Fonboarding"
        context.startActivity(
            Intent(Intent.ACTION_VIEW).apply {
                setPackage("com.android.vending")
                data = Uri.parse(uriString)
                putExtra("overlay", true)
                putExtra("callerId", context.packageName)
            }
        )
    }

    fun getClient(context: Context): HealthConnectClient {
        return HealthConnectClient.getOrCreate(context)
    }

    fun launchApp(context: Context) {
        val intent =
            context.packageManager.getLaunchIntentForPackage(providerPackageName)
        intent?.action = HealthConnectClient.ACTION_HEALTH_CONNECT_SETTINGS
        context.startActivity(intent)
    }

}