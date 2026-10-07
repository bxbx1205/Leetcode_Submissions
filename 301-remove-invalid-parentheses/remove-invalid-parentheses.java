class Solution {

    public void helper(Set<String> ans, String s, String current,
                       int n, int cnt, int i) {

        if (cnt < 0) {
            return;
        }

        if (i == n) {
            if (cnt == 0) {
                ans.add(current);
            }
            return;
        }

        if (s.charAt(i) == '(') {

            helper(ans, s, current + '(', n, cnt + 1, i + 1);

            helper(ans, s, current, n, cnt, i + 1);
        }

        else if (s.charAt(i) == ')') {

            helper(ans, s, current + ')', n, cnt - 1, i + 1);

            helper(ans, s, current, n, cnt, i + 1);
        }

        else {

            
            helper(ans, s, current + s.charAt(i), n, cnt, i + 1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {

        Set<String> set = new HashSet<>();

        helper(set, s, "", s.length(), 0, 0);

        int maxCnt = 0;

        for (String str : set) {
            maxCnt = Math.max(maxCnt, str.length());
        }

        List<String> ans = new ArrayList<>();

        for (String str : set) {
            if (str.length() == maxCnt) {
                ans.add(str);
            }
        }

        return ans;
    }
}