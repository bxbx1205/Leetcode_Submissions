class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[k] = 0;
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int currentDist = current[0];
            int currentNode = current[1];

            for (int[] getAdj : adj.get(currentNode)) {
                int nextNode = getAdj[0];
                int weight = getAdj[1];

                if (currentDist + weight < distance[nextNode]) {
                    distance[nextNode] = currentDist + weight;
                    pq.offer(new int[]{distance[nextNode], nextNode});
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, distance[i]);
        }

        return ans;
    }
}