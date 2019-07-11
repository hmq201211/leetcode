import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        int size = set.size();
        if (size >= candies.length / 2) {
            return candies.length / 2;
        } else {
            return size;
        }
    }
}