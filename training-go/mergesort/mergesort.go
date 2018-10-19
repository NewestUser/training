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

	firstIndex, secondIndex := 0, 0

	for mergeIndex := 0; mergeIndex < len(mergedArr); mergeIndex ++ {

		firstHasMore := firstIndex < len(first)
		secondHasMore := secondIndex < len(second)

		if firstHasMore && secondHasMore {

			if first[firstIndex] <= second[secondIndex] {
				mergedArr[mergeIndex] = first[firstIndex]
				firstIndex++
			} else {
				mergedArr[mergeIndex] = second[secondIndex]
				secondIndex++
			}

		} else if firstHasMore {
			mergedArr[mergeIndex] = first[firstIndex]
			firstIndex++

		} else if secondHasMore {
			mergedArr[mergeIndex] = second[secondIndex]
			secondIndex++
		}
	}

	return mergedArr
}
