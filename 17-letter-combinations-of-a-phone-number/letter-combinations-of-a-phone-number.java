class Solution {

    static void recurse(int index,HashMap<Character,String> map,String string,String digit,List<String> ans){
        if(index==digit.length()){
            ans.add(string);
            return;
        }
        
        for(char c : map.get(digit.charAt(index)).toCharArray()){
            recurse(index+1,map,string+c,digit,ans);
        }
    }
    public List<String> letterCombinations(String digits) {

    if(digits.length()==0){
        return new ArrayList<String>();
    }
     HashMap<Character,String> map = new HashMap<>();
     map.put('2',"abc");
     map.put('3',"def");
     map.put('4',"ghi");
     map.put('5',"jkl");
     map.put('6',"mno");
     map.put('7',"pqrs");
     map.put('8',"tuv");
     map.put('9',"wxyz");

     List<String> ans = new ArrayList<>();
     recurse(0,map,"",digits,ans);
     return ans;
    }
}