package Array.Medium;

public class ContainerWithMostWater {
    static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    static public int maxArea(int[] height) {
        int left=0;
        int right= height.length-1;
        int area= Integer.MIN_VALUE;

        while (left<right){
            int currentArea=(Math.min(height[left],height[right] )*(right-left));
            area=Math.max(currentArea,area);

            if (height[left]>height[right]) right--;
            else left++;


        }
 return area;
    }
}
