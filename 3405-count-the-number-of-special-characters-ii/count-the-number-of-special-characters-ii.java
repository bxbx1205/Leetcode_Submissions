class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lowercase= new int[26];
        int[] uppercase= new int[26];
        int cnt=0;

        Arrays.fill(lowercase,-1);
        Arrays.fill(uppercase,-1);
        int n=word.length();
        char[] arr = word.toCharArray();

        for(int i=0;i<n;i++){
            char ch = arr[i];
            if(ch>='a' && ch<='z'){
                int index= ch-'a';
                lowercase[index]=i;
            }
            else {
                int index=ch-'A';
                if(uppercase[index]==-1){
                    uppercase[index]=i;
                }
                
            }
        }

        for(int i=0;i<26;i++){
            if(lowercase[i]!=-1 && uppercase[i]!=-1 && lowercase[i]<uppercase[i]){
                cnt++;
            }
        }

    return cnt;
    }
}