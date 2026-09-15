class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int start = 0; start <= n - k; start++) {

            // Check palindrome of length k
            if (isPalindrome(s, start, start + k - 1)) {
                count++;
                start += k - 1;
            }

            // Check palindrome of length k + 1
            else if (start < n - k && isPalindrome(s, start, start + k)) {
                count++;
                start += k;
            }
        }

        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}