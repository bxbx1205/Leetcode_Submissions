class Solution {
    public String reverse(String word){
        StringBuilder ans = new StringBuilder();
        int n = word.length()-1;

        for(int i=n;i>=0;i--){
            ans.append(word.charAt(i));
        }
        return ans.toString();

    }
    public String reversePrefix(String word, char ch) {
        StringBuilder ans = new StringBuilder();
        int i=0;
        String rev="";
         boolean found = false;
        for(i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                rev = reverse(word.substring(0,i+1));
                i++;
                found = true;
                break;
            }
        }

        if (!found) {
            i = 0;
        }
        ans.append(rev);

        while(i<word.length()){
            ans.append(word.charAt(i++));
        }

    return ans.toString();
    }
}