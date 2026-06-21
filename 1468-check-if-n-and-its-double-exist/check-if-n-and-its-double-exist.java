class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> map = new HashSet<>();

        for(int num:arr){
            int current=2*num;
            if(map.contains(current)|| (num%2==0) && (map.contains(num/2))){
                return true;
            }     
            map.add(num);
        }



        return false;
    }
}



