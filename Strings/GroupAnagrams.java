package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word: strs){
            char[] ch = word.toCharArray(); // converting into char arrays.
            Arrays.sort(ch); // sorting the characters.
            String sortedWord = new String(ch);

            if (!map.containsKey(sortedWord))
                map.put(sortedWord, new ArrayList<>());

            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        
    }
}
