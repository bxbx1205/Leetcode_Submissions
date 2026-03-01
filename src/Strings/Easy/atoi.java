package Strings.Easy;

public class atoi {
    static void main(String[] args) {
        String s = "1337c0d3";
        System.out.println(myAtoi(s));

    }

    static public int myAtoi(String s) {
        s = s.trim();

        if (s.isEmpty()) return 0;

        int i = 0;
        long result = 0;
        int sign = 1;

        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch < '0' || ch > '9') break;

            result = result * 10 + (ch - '0');

            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            i++;
        }
        return (int) result * sign;
    }
}
