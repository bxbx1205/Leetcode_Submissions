package Array.Hard;
import java.util.*;
public class missingRep {
    public static void main(String[] args) {
        int[] arr= {1, 3, 3};
        System.out.println(Arrays.toString(findTwoElement(arr)));
    }
    static int[] findTwoElement(int[] arr) {
        int n = arr.length;

        long sn = (long) n *(n+1)/2;
        long sn2= (long) n * (n + 1) * (2L * n + 1) / 6;

        long realSum=0;
        long sqSum=0;
        for (int j : arr) {
            realSum += j;
            sqSum += (long) j * j;
        }

        long value1= realSum-sn;
        long value2= sqSum-sn2;


        value2=value2/value1;

        long x = (value1+value2)/2;
        long y = x-value1;

        return new int[]{(int)x,(int)y};
    }
}
