package MultiplyStrings;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        // taking length of the both strings
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];
        // smartly manipulating strings to digit one by one and calculating it.
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                // calculating product digit by digit
                int mul = d1 * d2;
                int sum = mul + result[i + j + 1];
                // appending calcualted values to the array
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
// String builder for convertion from int to string.
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(multiply("2", "21"));
    }
}
