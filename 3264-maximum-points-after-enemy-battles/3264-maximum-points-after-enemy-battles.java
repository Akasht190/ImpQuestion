// class Solution {
//     public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
//         int min=Arrays.stream(enemyEnergies).min().getAsInt();
//         if(currentEnergy<min){
//             return 0;
//         }
//         currentEnergy-=min;
//         for(int energy:enemyEnergies) currentEnergy+=energy;
//         return currentEnergy/min;
//     }
// }
public class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
         long total = currentEnergy;
        Arrays.sort(enemyEnergies);
        if(currentEnergy < enemyEnergies[0]) return 0;
        for(int i = 1; i < enemyEnergies.length; i++){
            total += enemyEnergies[i];
        }
        return total / enemyEnergies[0];
    }
}