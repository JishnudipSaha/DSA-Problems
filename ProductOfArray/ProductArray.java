public class ProductArray {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // Prefix sum array
        result[0] = 1;
        for(int i = 1; i < nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        // Suffix sum array
        int right = 1;
        for(int i = n-1; i>=0; i--){
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        ProductArray productArray = new ProductArray();
        int answer[] = productArray.productExceptSelf(new int[]{1,2,3,4});
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
