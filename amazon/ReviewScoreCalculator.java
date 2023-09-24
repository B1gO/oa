import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReviewScoreCalculator {
    
    public static int getLen(String review, String[] words) {
        // 将review转为小写，使比较过程中不区分大小写
        review = review.toLowerCase();
        
        // i和j是双指针，用于形成滑动窗口的起点和终点
        int i = 0;
        int j = 0;
        
        // 用于存储满足条件的最大子串长度
        int maxLen = 0;

        // j指针遍历整个review
        while (j < review.length()) {

            // 获取当前i和j指针界定的子串
            String subStr = review.substring(i, j + 1);

            // 假设当前子串是合法的，即不包含禁用词
            boolean isValid = true;
            // 用于存储找到的禁用词
            String w = "";
            
            // 遍历禁用词列表
            for (String prohibWord : words) {
                // 检查当前子串的长度是否大于或等于禁用词，并且子串是否以该禁用词结束
                if (subStr.length() >= prohibWord.length() && subStr.endsWith(prohibWord.toLowerCase())) {
                    isValid = false;
                    w = prohibWord; // 记录匹配到的禁用词
                    break; // 一旦匹配到禁用词，跳出循环
                }
            }
            // 如果当前子串是合法的
            if (isValid) {
                // 更新最大子串长度
                maxLen = Math.max(maxLen, j - i + 1);
            } else {
                // 如果当前子串包含禁用词，调整i指针到禁用词结束的下一个位置
                i = j - w.length() + 2;
            }
            // 移动j指针到下一个位置
            j++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // 15
        // 11
        // 20
        String[] reviews = {
            "GoodProductButScrapAfterWash",
            "FastDeliveryOkayProduct",
            "ExtremeValueForMoney"
        };

        String[][] prohibitedLists = {
            {"crap", "odpro"}, 
            {"eryoka", "yo", "eli"}, 
            {"tuper", "douche"}
        };

        for (int i = 0; i < reviews.length; i++) {
            System.out.println(getLen(reviews[i], prohibitedLists[i]));
        }
    }

 
}
