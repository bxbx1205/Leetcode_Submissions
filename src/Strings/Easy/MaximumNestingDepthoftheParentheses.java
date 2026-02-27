package Strings.Easy;

public class MaximumNestingDepthoftheParentheses {
    static void main(String[] args) {
        String s=  s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }
    static public int maxDepth(String s) {
        int max= 0;
        int depth=0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                depth+=1;
                max=Math.max(max,depth);
            } else if (s.charAt(i)==')') {
                depth-=1;
            }
            else continue;
        }
        return max;
    }
}
