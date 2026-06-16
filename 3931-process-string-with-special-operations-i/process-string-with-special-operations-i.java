class Solution {
    public StringBuilder star(StringBuilder s){
        StringBuilder ans = new StringBuilder();
        if(s.length()==0 || s.length()==1) return ans.append("");
        
        return ans.append(s.substring(0,s.length()-1));
    }

    public StringBuilder hash(StringBuilder s){
        // if(s.length()==0) return " ";
        StringBuilder ans = new StringBuilder();

        
        return s.append(s);
    }

    public StringBuilder percent(StringBuilder s){
        StringBuilder ans = new StringBuilder();
        
        for(int i = s.length()-1;i>=0;i--){
            ans.append(s.charAt(i));
        }
        return ans;
    }


    public String processStr(String s) {

        StringBuilder ans = new StringBuilder();

        int n = s.length();

        for(int i =0;i<n ;i++){
            char current = s.charAt(i);
            if(current>='a' && current<='z'){
                ans.append(current);
            }
            else if(current=='*'){
                ans=star(ans);
            }
            else if(current=='#'){
                ans=hash(ans);
            }
            else if(current=='%'){
                ans=percent(ans);
            }
        }

        return ans.toString();
        // working percent return percent("sarvesh");
        // hash working return hash("a").toString();
        // star working return star(s).toString();
    }
}