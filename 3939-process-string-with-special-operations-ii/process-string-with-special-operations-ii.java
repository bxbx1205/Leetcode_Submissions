class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long length = 0;
        long[] len = new long[n];

        for(int i =0;i<n;i++){
            char current=s.charAt(i);

            if(current>='a' && current<='z'){
                length+=1;
            }
            else if (current=='#'){
                length*=2;
            }
            else if (current=='*'){
                if(length>0) length-=1;
            }

            len[i]=length;
        }
        if(k<0 || k>=len[n-1]){
            return '.';
        }

        for(int i=n-1;i>=0;i--){
            char current = s.charAt(i);
            long prevLen=(i==0)?0:len[i-1];

             if(current>='a' && current<='z'){
                if(k==prevLen){
                    return current;
                }
            }
             else if (current=='#'){
                if(k>=prevLen){
                    k-=prevLen;
                }
            }
            else if (current=='%'){
                k=prevLen-1-k;
            }
        }

        return '.';
    }
}