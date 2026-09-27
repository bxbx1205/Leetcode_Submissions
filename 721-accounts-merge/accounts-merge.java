class Solution {
    public int find(int[] parent,int x){
        if(parent[x]==x){
            return x;
        }

        return parent[x]=find(parent,parent[x]);
    }

    public void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);

        if (pa != pb) {
            parent[pb] = pa;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){

            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);

                if(map.containsKey(email)){
                    union(parent, i, map.get(email));
                }
                else{
                    map.put(email,i);
                }
            }
        }

        HashMap<Integer,List<String>> group = new HashMap<>();

        for(String email : map.keySet()){
            int account = map.get(email);

            int root = find(parent,account);

            group.putIfAbsent(root, new ArrayList<>());

            group.get(root).add(email);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int root : group.keySet()) {

            List<String> emails = group.get(root);

            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(accounts.get(root).get(0));

            account.addAll(emails);

            ans.add(account);
        }

        return ans;


    }
}