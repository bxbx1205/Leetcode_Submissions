class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int n1=nums1.length;
        int n2=nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] answer = new int[n1];

        for(int num:nums2){

            while(!stack.isEmpty() && num>stack.peek()){
                int small=stack.pop();

                map.put(small,num);
            }
            stack.push(num);
        }

        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }

        for(int i=0;i<n1;i++){
            answer[i]=map.get(nums1[i]);
        }

        return answer;
    }
}