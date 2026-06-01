class Solution {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int n = num.length();

        if (k == n)
            return "0";

        int dupedK = k;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && k > 0 && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));

        }

            while (k != 0 && !stack.isEmpty()) {
                stack.pop();
                k--;
            }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        int howmanyZero = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                howmanyZero++;
            } else {
                break;
            }
        }

        String result = sb.substring(howmanyZero);
        return result.isEmpty() ? "0" : result;

    }
}