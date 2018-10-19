package mergesort

import (
	"reflect"
	"testing"
)

func TestMergeSort(t *testing.T) {

	type scenario struct {
		unsorted []int
		sorted   []int
	}

	scenarios := []scenario{
		{unsorted: []int{6, 5, 3, 4}, sorted: []int{3, 4, 5, 6}},
		{unsorted: []int{7, 6, 5, 3, 4}, sorted: []int{3, 4, 5, 6, 7}},
		{unsorted: []int{7, 6, 5, 3, 4, 8}, sorted: []int{3, 4, 5, 6, 7, 8}},
		{unsorted: []int{7, 5, 6, 5, 3, 4, 8}, sorted: []int{3, 4, 5, 5, 6, 7, 8}},
	}

	for _, s := range scenarios {

		got := MergeSort(s.unsorted)

		if !reflect.DeepEqual(got, s.sorted) {
			t.Fatalf("\ngot : %v\nwant: %v", got, s.sorted)
		}

	}
}
