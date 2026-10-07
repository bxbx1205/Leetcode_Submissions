class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] present = new int[26];

        Arrays.fill(present,0);
        for(char ch : magazine.toCharArray()){
            present[ch-'a']++;
        }

        for(char ch : ransomNote.toCharArray()){
            // if(!present[ch-'a']) return false;
            if(present[ch-'a']==0){
                return false;
            }
            else{
                present[ch-'a']--;
            }
        }

        return true;
    }
}