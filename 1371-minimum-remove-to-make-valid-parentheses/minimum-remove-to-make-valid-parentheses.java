class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int openCnt=0;

        for(int i=0;i<n;i++){

            if(str[i]>='a' && str[i]<='z'){
                continue;
            }

            else if(str[i]=='('){
                openCnt++;
            }
            else{
                if(openCnt>0){
                    openCnt--;
                }
                else{
                    str[i]='#';
                }
            }
        }

        for(int i =n-1;i>=0;i--){
            if (openCnt==0) break;
            if(openCnt>0 && str[i]=='('){
                str[i] = '#'; 
                openCnt--;
            }
        }

        StringBuilder ans= new StringBuilder();

        for(char val : str){
            if(val!='#'){
                ans.append(val);
            }
        }

        return ans.toString();
    }
}