class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int left=0;
        int right=0;
        int cnt=0;
        int minLength=Integer.MAX_VALUE;
        int startIndex=-1;
        HashMap<Character,Integer> map = new HashMap<>();


        for(int i=0;i<m;i++){
            char current=t.charAt(i);
            map.put(current,map.getOrDefault(current,0)+1);
        }


        while(right<n){
            char current = s.charAt(right);

            map.put(current,map.getOrDefault(current,0)-1);

            if(map.get(current)>=0){
                cnt++;
            }

            while(cnt==m){
                if(right-left+1<minLength){
                    minLength=right-left+1;
                    startIndex=left;
                }

                map.put(s.charAt(left),map.get(s.charAt(left))+1);
                if(map.get(s.charAt(left))>0){
                    cnt--;
                }

                left++;
            }

            right++;
        }

        return startIndex==-1?"":s.substring(startIndex,minLength+startIndex);
    }
}