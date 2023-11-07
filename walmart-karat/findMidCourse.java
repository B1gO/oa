

import java.util.*;

public class findMidCourse {
    public static void main(String[] args) {
        String[][] courses = new String[][] {
            {"Foundations of Computer Science", "Operating Systems"},
            {"Data Structures", "Algorithms"},
            {"Computer Networks", "Computer Architecture"},
            {"Algorithms", "Foundations of Computer Science"},
            {"Computer Architecture", "Data Structures"},
            {"Software Design", "Computer Networks"}
        };
        String res = getMiddleClass(courses);
        System.out.println(res);

        String[][] courses2 = new String[][]{
                {"Algorithms", "Foundations of Computer Science"},
                {"Data Structures", "Algorithms"},
                {"Foundations of Computer Science", "Logic"},
                {"Logic", "Compilers"},
                {"Compilers", "Distributed Systems"}};
        String res2 = getMiddleClass(courses2);
        System.out.println(res2);

        String[][] courses3 = new String[][]{
                {"Data Structures", "Algorithms"}};
        String res3 = getMiddleClass(courses3);
        System.out.println(res3);
    }

    public static String getMiddleClass(String[][] courses) {
        Set<String> pres = new HashSet<>();
        Set<String> currs = new HashSet<>();
        Map<String, String> map = new HashMap<>();

        for (String[] course : courses) {
            pres.add(course[0]);
            currs.add(course[1]);
            map.put(course[0], course[1]);
        }

        String enter = "";
        for (String pre : pres) {
            if (!currs.contains(pre)) {
                enter = pre;
            }
        }

        if (enter.length() == 0) {
            return null;
        }

        List<String> list = new ArrayList<>();
        list.add(enter);
        while (enter != null && map.containsKey(enter)) {
            enter = map.get(enter);
            list.add(enter);
        }

        if (list.size() % 2 == 0) {
            return list.get(list.size() / 2 - 1);
        } else {
            return list.get(list.size() / 2);
        }
    }
}
