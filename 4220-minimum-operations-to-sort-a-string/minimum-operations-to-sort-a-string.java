class Solution {

    public boolean isSorted(String s) {
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public int minOperations(String s) {

        int n = s.length();

        if (isSorted(s)) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }

        char minC = s.charAt(0);
        char maxC = s.charAt(0);

        for (int i = 1; i < n; i++) {
            minC = (char) Math.min(minC, s.charAt(i));
            maxC = (char) Math.max(maxC, s.charAt(i));
        }

        if (s.charAt(0) == minC || s.charAt(n - 1) == maxC) {
            return 1;
        }

        for (int i = 1; i < n - 1; i++) {

            if (s.charAt(i) == minC || s.charAt(i) == maxC) {
                return 2;
            }
        }

        return 3;
    }
}