package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    void generate(int n, List<String> result, int o, int c, String s){
        if (s.length() == 2*n){
            result.add(s);
        }
        if (o < n) generate(n, result, o+1, c, s +"(");
        if (c < o) generate(n, result, o, c + 1, s +")");
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, result, 0, 0, "");
        return result;
    }
    public static void main(String[] args) {
        
    }
}
