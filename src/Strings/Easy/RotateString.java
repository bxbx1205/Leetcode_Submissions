package Strings.Easy;

public class RotateString {
    static void main(String[] args) {
        String S = "abcde";
        String Goal="cdeab";

        System.out.println(rotateString(S,Goal));
    }
    static public boolean rotateString(String s, String goal) {
        if (s.length()!=goal.length()) return false;

        return (s.concat(s).contains(goal));
    }
}
