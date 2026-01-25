package QuestionPractices;

public class SwapNumbers {
    static int[] swapNums(int a, int b){
        int x = a;
        int y = b;
        x = (a+b) - (y=a); // swapping in oneline
        return new int[]{x, y};
    }
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        // 
        System.out.printf("Before swap: a = %d and b = %d\n", a, b);
        // after swapping
        int[] swap = swapNums(a, b);
        System.out.printf("After swap: a = %d and b = %d", swap[0], swap[1]);
    }
}
