package Strings;

public class LastWordLength {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lidx = s.lastIndexOf(' ');
        return (s.length() - 1) - lidx;
    }
    public static void main(String[] args) {
        
    }
}
