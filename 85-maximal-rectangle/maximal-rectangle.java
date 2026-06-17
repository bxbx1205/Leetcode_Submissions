class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] pSum = new int[n][m];

        for (int j = 0; j < m; j++) {

            int sum = 0;

            for (int i = 0; i < n; i++) {

                if (matrix[i][j] == '1') {
                    sum++;
                } else {
                    sum = 0;
                }

                pSum[i][j] = sum;
            }
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestHistogram(pSum[i]));
        }

        return maxArea;
    }

    private int largestHistogram(int[] heights) {

        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] > currHeight) {

                int h = heights[st.pop()];

                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();

                int width = right - left - 1;

                maxArea = Math.max(maxArea, h * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}