class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
          long currentMass = mass; 
        for(int value: asteroids){
            if(currentMass<value){
                return false;
            }
            currentMass+=value;
        }

        return true;
    }
}