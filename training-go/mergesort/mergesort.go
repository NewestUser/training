package mergesort

func MergeSort(arr []int) []int {

	if len(arr) < 2 {
		return arr
	}

	middle := len(arr) / 2;
	leftHalf := arr[0:middle]
	rightHalf := arr[middle:]

	sortedLeftHalf := MergeSort(leftHalf)
	sortedRightHalf := MergeSort(rightHalf)

	return merge(sortedLeftHalf, sortedRightHalf)
}

func merge(first, second []int) []int {
	mergedArr := make([]int, len(first)+len(second))

	firstPivot, secondPivot, mergePivot := 0, 0, 0

	for ; firstPivot < len(first) && secondPivot < len(second); {
		if first[firstPivot] <= second[secondPivot] {
			mergedArr[mergePivot] = first[firstPivot]
			firstPivot++
			mergePivot++
		} else {
			mergedArr[mergePivot] = second[secondPivot]
			secondPivot++
			mergePivot++
		}
	}

	for ; firstPivot < len(first); {
		mergedArr[mergePivot] = first[firstPivot]
		firstPivot++
		mergePivot++
	}

	for ; secondPivot < len(second); {
		mergedArr[mergePivot] = second[secondPivot]
		secondPivot++
		mergePivot++
	}

	return mergedArr
}