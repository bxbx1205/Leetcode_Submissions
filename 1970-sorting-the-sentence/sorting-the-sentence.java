class Solution {
    public String sortSentence(String s) {
        String[] words= s.split(" ");
        String[] position = new String[words.length];

        for(String current:words){
            int positionN=current.charAt(current.length()-1)-'0';
            position[positionN-1]=current.substring(0,current.length()-1);
        }
        
        return String.join(" ", position);
    }
}