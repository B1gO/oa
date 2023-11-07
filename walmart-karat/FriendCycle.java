

public class FriendCycle {
    public static void main(String[] args) {
        String[] relationship = new String[]{"1,2", "1,3", "3,4"};
        String[] employees = new String[]{
                "1, Bill, Engineer",
                "2, Joe, HR",
                "3, Sally, Engineer",
                "4, Richard, Business",
                "6, Tom, Engineer"};
        Map<String, Set<String>> res = findFriendCycle(employees, relationship);
    }

    private static Map<String, Set<String>> findFriendCycle(String[] employees, String[] friendships) {
        Map<String, Set<String>> result = new HashMap<>();
        for (String employee : employees) {
            String[] str = employee.split(",");
            result.put(str[0], new HashSet<>());
        }

        for (String friendship : friendships) {
            String[] ppl = friendship.split(",");
            String ppl1 = ppl[0];
            String ppl2 = ppl[1];
            Set<String> set1 = result.get(ppl1);
            set1.add(ppl2);
            result.put(ppl1, set1);

            Set<String> set2 = result.get(ppl2);
            set2.add(ppl1);
            result.put(ppl2, set2);
        }

        return result;
    }
}