class Solution {
    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        int count = 0;

        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid + 1, right);
        count += merge(arr, left, mid, right);

        return count;
    }
    static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        return invCount;
    }
}