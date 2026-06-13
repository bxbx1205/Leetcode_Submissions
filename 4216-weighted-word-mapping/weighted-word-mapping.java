class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();


        for(int i=0;i<words.length;i++){
            String current=words[i];
            int sum=0;
            for(int j=0;j<current.length();j++){
                char ch=current.charAt(j);
                sum= sum+weights[ch-'a'];
            }
            int number = sum%26;
            char mappedChar = (char) ('a' + (25 - number));
            ans.append(mappedChar);
        }

        return ans.toString();
    }
}