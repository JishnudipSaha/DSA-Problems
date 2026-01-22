package MultiplyStrings;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        int prod = n1 * n2; 
        return String.valueOf(prod);
    }
    public static void main(String[] args) {
        System.out.println(multiply("2", "21"));
    }
}
