package Array.Hard;
import java.util.*;
public class MissingRepaerting {
    public static void main(String[] args) {
        int[] arr= {1, 3, 3};
        System.out.println(findTwoElement(arr));
    }
    static ArrayList<Integer> findTwoElement(int arr[]) {
        HashSet<Integer> map = new HashSet<>();
        int[] ans = new int[2];
        List<Integer> list= new ArrayList<>();
        int duplicate=0;
        for (int i = 0; i < arr.length; i++) {

            if (map.contains(arr[i])){
                 duplicate= arr[i];
                 ans[0]=duplicate;
                list.add(duplicate);
                break;
            }
            else {
                map.add(arr[i]);
            }
        }
        int xor=0;
        for (int i = 1; i <= arr.length ; i++) {
            xor^=i;
        }
        xor^=duplicate;

        for (int i = 0; i < arr.length; i++) {
            xor^=arr[i];
        }
        ans[1]=xor;
        list.add(xor);
        System.out.println(Arrays.toString(ans));


        return (ArrayList<Integer>) list;
//        return new int[] {ArrayList}
    }
}
