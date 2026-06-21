class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max=0;

        for(int num:costs){
            max=Math.max(max,num);
        }

        int[] freq = new int[max+1];
        Arrays.fill(freq, 0);

        for(int num:costs){
            freq[num]+=1;
        }
        int cnt=0;
        for(int i=0;i<freq.length;i++){

            while(freq[i]>0){
                if(coins<i){
                    break;
                }
                coins-=i;
                cnt++;
                freq[i]--;
            }
        }
        return cnt;

    }
}