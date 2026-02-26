package Strings.Easy;
import java.util.*;

public class SortCharactersByFrequency {
    static void main(String[] args) {
        String s= "Aabb";
        System.out.println(frequencySort(s));

    }
    static public String frequencySort(String s) {
        Map<Character,Integer> freqMap= new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a,b)->freqMap.get(b)-freqMap.get(a)
        );

        pq.addAll(freqMap.keySet());

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()){
            char ch = pq.poll();

            int freq= freqMap.get(ch);

            while (freq-->0){
                result.append(ch);
            }
        }
        return result.toString();
    }
}
