class Solution {
    public int totalWaviness(int num1, int num2) {
        int wavy = 0;
        
        for (int i = num1; i <= num2; i++) {
            String s = String.valueOf(i);
            
            for (int j = 0; j <= s.length() - 3; j++) {
                int left = s.charAt(j);
                int mid = s.charAt(j + 1);
                int right = s.charAt(j + 2);
                
                if ((mid > left && mid > right) || (mid < left && mid < right)) {
                    wavy++;
                }
            }
        }
        return wavy;
    }
}
