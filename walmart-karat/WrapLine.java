

import java.util.*;
public class WrapLine {
    public static void main(String args[]) {
        String[] words = {"1p3acres", "is", "a", "good", "place", "to", "communicate"};
        List<String> res = wrapLines(words, 12);
        for (String str : res) {
            System.out.println(str + ", "); 
        }
    }
    
    private static List<String> wrapLines(String[] words, int maxLength) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String word = words[i];
            if (sb.length() == 0) {
                if (word.length() > maxLength) {
                    res.add(word);
                } else {
                    sb.append(word);
                }
            } else {
                if (sb.length() + 1 + word.length() <= maxLength) {
                    sb.append("-");
                    sb.append(word);
                } else {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                    i--;
                }
            }
        }

        if (sb.length() != 0) {
            res.add(sb.toString());
        }
        return res;
    }
}