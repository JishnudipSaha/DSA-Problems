package SortingAlgorithm;

public class BubbleSort {

    static int[] bubbleSort(int[] arr){
        int len = arr.length;
        for(int i = len; i >  0; i--){
            for (int j = 1; j < i; j++) {
                if (arr[j - 1] > arr[j]) {
                // swaping useing XOR operation
                arr[j]=arr[j-1]^arr[j];
                arr[j-1]=arr[j-1]^arr[j];
                arr[j]=arr[j-1]^arr[j];
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        // Bubble sorting
        int[] arr = new int[]{7,2,1,4,8,3};
        arr = bubbleSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        
    }
}
