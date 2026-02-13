public class MountainPeak {
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end){

            mid = (start + end)/2;

            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid + 1]) return mid;

            else if (arr[mid] < arr[mid -1]) {
                end = mid;
            }else {
                start = mid;
            }
            
        }
        return mid;
    }

    public static void main(String[] args) {
        // calling the static function from the main.
        System.out.println(peakIndexInMountainArray(new int[]{0,10,5,2}));
    }
}
