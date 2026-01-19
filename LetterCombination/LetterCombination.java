package LetterCombination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombination {

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(0, digits, "", mapping, result);
        return result;
    }

    private static void backtrack(int index, String digits, String current, String[] mapping, List<String> result) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];

        for (int i = 0; i < letters.length(); i++) {
            backtrack(index + 1, digits, current + letters.charAt(i), mapping, result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter digits (2-9 only): ");
        String digits = sc.nextLine();

        List<String> result = letterCombinations(digits);

        System.out.println("Possible combinations:");
        System.out.println(result);

        sc.close();
    }
}
