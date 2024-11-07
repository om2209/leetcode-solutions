import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> persons = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            persons.add(i+1);
        }
        int index = 0;
        k--;

        while (persons.size() != 1) {
            index = (index + k) % persons.size();
            persons.remove(index);
        }

        return persons.get(0);
    }
}