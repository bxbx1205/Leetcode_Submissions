package Strings.Medium;

import java.util.HashMap;

public class MinimumDeletionstoMakeStringBalanced {
    public static void main(String[] args) {
        String  s = "bbaaaaabb";
        System.out.println(minimumDeletions(s));
    }

    static public int minimumDeletions(String s) {
        int countB=0;
//        int countA=0;
        HashMap<Integer,Integer> mapB = new HashMap<>();
        HashMap<Integer,Integer> mapA= new HashMap<>();


        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)!='b'){
                mapB.put(i,countB);
            }
            if (s.charAt(i)=='b'){
                countB++;
                mapB.put(i,countB);
            }
            int countA=n-countB-1;
            if (s.charAt(i)!='a'){
                mapA.put(i,countA);
            }
            if (s.charAt(i)=='a'){
                mapA.put(i,countA--);
            }
            int AA= mapA.get(i);
            int BB = mapB.get(i);

            if (AA>=BB){
                return i;
            }
        }


        return 0;
    }
}
