class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        // int n = knowledge.size();

        for(List<String> ls : knowledge){
            String key = ls.get(0);
            String value = ls.get(1);

            map.put(key,value);    
        }

        int index=0;
        int n =s.length();

        while(index<n){
            if(s.charAt(index)=='('){
                index++;
                StringBuilder temp = new StringBuilder();
                while(index<n && s.charAt(index)!=')'){
                    temp.append(s.charAt(index));
                    index++;
                }

                String temps= temp.toString();
                index++;

                if(map.containsKey(temps)){
                    sb.append(map.get(temps));
                }
                else{
                    sb.append('?');
                }
            }
            else{
                sb.append(s.charAt(index));
                index++;
            }
        }


        return sb.toString();
    }
}