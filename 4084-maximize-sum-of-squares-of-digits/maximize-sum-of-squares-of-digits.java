class Solution {
    public String maxSumOfSquares(int num, int sum) {

        if (sum > 9 * num) return "";

        StringBuilder ans = new StringBuilder();

        while (num > 0) {

            if (sum == 0) {
                ans.append('0');
                num--;
                continue;
            }

            if (sum < 9) {
                ans.append((char) ('0' + sum));
                sum = 0;
                num--;
            }
            else {
                ans.append('9');
                sum -= 9;
                num--;
            }
        }

        return ans.toString();
    }
}