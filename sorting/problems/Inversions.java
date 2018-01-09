package sorting.problems;

public class Inversions {

	public int mergeSort(int arr[], int start, int end) {
		int count_inversions = 0;
		if (start < end) {
			int mid = (start + end) / 2;
			count_inversions += mergeSort(arr, start, mid);
			count_inversions += mergeSort(arr, mid + 1, end);
			count_inversions += merge(arr, start, mid, end);

		}
		return count_inversions;
	}

	public int merge(int arr[], int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;
		int left[] = new int[n1 + 1];
		int right[] = new int[n2 + 1];
		for (int i = 0; i < n1; i++)
			left[i] = arr[start + i];
		for (int i = 0; i < n2; i++)
			right[i] = arr[mid + i + 1];
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		int count_inversions = 0;
		for (int k = start; k <= end; k++) {
			if (left[i] <= right[j]) {
				arr[k] = left[i++];
			} else {
				if (left[i] != Integer.MAX_VALUE) {
					count_inversions += left.length - 1 - i;
				}
				arr[k] = right[j++];
			}
		}
		return count_inversions;

	}

	public static void main(String agrs[]) {
		int arr[] = { 1, 20, 6, 4, 5 };
		Inversions inversions = new Inversions();
		System.out.println(inversions.mergeSort(arr, 0, arr.length - 1));
	}
}
