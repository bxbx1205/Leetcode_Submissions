class Solution {
    public boolean detectCapitalUse(String word) {

        
        //Character.isUpperCase
        int n = word.length();
        if(n<2) return true;
        // this is USA all caps
        if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))){

            for(int i=2;i<n;i++){
                if(!Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
        } 

        // this is leetcode
        else if(!Character.isUpperCase(word.charAt(0)) && !Character.isUpperCase(word.charAt(1))){

            for(int i=2;i<n;i++){
                if(Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
        } 
        else if(Character.isUpperCase(word.charAt(0)) && !Character.isUpperCase(word.charAt(1))){

            for(int i=2;i<n;i++){
                if(Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
        }
        else if(!Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))){
            return false;
        }

        return true;
    }
}