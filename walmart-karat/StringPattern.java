

public class StringPattern {
    private static String findFirstPattern(String[] words, String pattern) {
        if (words == null || words.length == 0) {
            return "-";
        }

        for (String word : words) {
            if (findWord(word, pattern)) {
                return word;
            }
        }
        return "-";
    }

    private static boolean findWord(String word, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> patternMap = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int cnt = entry.getValue();
            if (!patternMap.containsKey(ch) || (patternMap.containsKey(ch) && 
                    cnt > patternMap.get(ch))){
                return false;
            }
        }
        return true;
    }
}
