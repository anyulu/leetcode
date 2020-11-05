class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int start = 0, end = arr.length-1;
        if (arr[0] >= x) return list.subList(0,k);
        if (arr[end] <= x) return list.subList(end+1-k, end+1);
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (arr[mid] == x) {
                start = mid+1;
                end = mid;
                break;
            } else if (arr[mid] < x) start = mid+1;
            else end = mid-1;
        }
        List<Integer> result = new ArrayList<>();
        int size = k;
        while (size > 0) {
            size--;
            if (x-arr[end] <= arr[start]-x) result.add(0, arr[end--]);
            else result.add(arr[start++]);
            if (end < 0) return list.subList(0, k);
            if (start > arr.length-1) return list.subList(arr.length-k, arr.length);
        }
        return result;
    }
}