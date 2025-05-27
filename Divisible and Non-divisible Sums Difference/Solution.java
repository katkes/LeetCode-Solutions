public class Solution {
    public int differenceOfSums(int n, int m) {
        int sum = 0;
        
        for (int num = 1; num <= n; num++){
            if (num % m == 0) sum -= num;
            else sum += num;
        }

        return sum;
    }
}
