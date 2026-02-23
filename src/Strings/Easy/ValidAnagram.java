package Strings.Easy;

import java.util.Arrays;

public class ValidAnagram {
    static void main(String[] args) {
        String  s = "anagram";
        String t = "nagrram";
        System.out.println(isAnagram(s,t));
    }

    static public boolean isAnagram(String s, String t) {

        if (s.length()!=t.length()) return false;

        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        Arrays.sort(sarr);
        Arrays.sort(tarr);

        String sstring = new String(sarr);
        String tstring = new String(tarr);


        if (sstring.equals(tstring)) return true;

        return false;
    }
}
