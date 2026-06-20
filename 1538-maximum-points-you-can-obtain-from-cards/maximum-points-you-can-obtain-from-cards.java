class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum=0;
        int n = cardPoints.length;
        for(int num: cardPoints){
            totalSum+=num;
        }

        if(k==n) return totalSum;

        int max=0;
        int left=0;
        int dupK=k;
        int originalK = k;
        while(k>0){
            max+=cardPoints[left];
            left++;
            k--; 
        }

         dupK=originalK; 
        int ans=max;        
        int right=n-1;
        left--;        

        while(dupK>0){
            max -= cardPoints[left];  
            max += cardPoints[right]; 
            ans = Math.max(ans, max);
            
            left--;
            right--;
            dupK--;
        }
        return ans;
    }
        
    
}