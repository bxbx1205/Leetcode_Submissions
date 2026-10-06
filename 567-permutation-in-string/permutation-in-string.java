class Solution {
    public boolean compare(int[] a1,int[] a2){
        for(int i=0;i<a1.length;i++){
            if(a1[i]!=a2[i]) return false;
        }

        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] a1 = new int[26];

        int m = s2.length();
        int[] a2 = new int[26];

        Arrays.fill(a1,0);
        Arrays.fill(a2,0);

        for(char ch : s1.toCharArray()){
            a1[ch-'a']++;
        }

        int i=0;
        int j =0;

        while(j<n && j<s2.length()){
            char current =s2.charAt(j);
            a2[current-'a']++;
            j++;
        }

        while(j<m){
            if(compare(a1,a2)){
                return true;
            }
            a2[s2.charAt(i)-'a']--;
            a2[s2.charAt(j)-'a']++;
            i++;
            j++;
        }

        return compare(a1,a2);
    }
}