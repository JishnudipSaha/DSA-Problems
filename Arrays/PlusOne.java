public class PlusOne {
    public static int[] plusOne(int[] digits) {
        if (digits[digits.length-1] < 9) {
            digits[digits.length-1]++;
            return digits;
        }

        int carry = 1;
        digits[digits.length-1] = 0;
        int n = digits.length - 2;
        while (n >= 0){
            int sum = digits[n] + carry;
            digits[n] = sum%10;
            carry = sum/10;
            if (carry == 0) break;
            n--;
        }
        if (carry == 1){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int i = 1; i < digits.length+1; i++){
                result [i] = digits[i-1];
            }
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = plusOne(new int[]{9,9});
        for (int i: arr){
            System.out.print(i + " ");
        }
//        System.out.println(16%10);
//        System.out.println(16/10);
    }
}
