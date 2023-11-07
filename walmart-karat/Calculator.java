
public class Calculator {
    public static void main(String[] args) {
        String test1 = "1+2-3+4";
        String test2 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculator1(test1));
        System.out.println(calculator2(test2));
    }
    
    private static int calculator1(String s) {
        int num = 0, sign = 1, res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + Integer.valueOf(ch - '0');
            }
            if (ch == '+') {
                res += num * sign;
                num = 0;
                sign = 1;
            }
            if (ch == '-') {
                res += num * sign;
                num = 0;
                sign = -1;
            }
        }

        res += num * sign;
        return res;
    }

    private static int calculator2(String s) {
        int num = 0, res = 0, sign = 1;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + Integer.valueOf(ch - '0');
            }
            if (ch == '+') {
                res += num * sign;
                num = 0;
                sign = 1;
            }
            if (ch == '-') {
                res += num * sign;
                num = 0;
                sign = -1;
            }
            if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            if (ch == ')') {
                res += num * sign;
                res *= stack.pop();
                res += stack.pop();
                num = 0;
            }
        }

        if (num != 0) {
            res += num * sign;
        }
        return res;
    }
}