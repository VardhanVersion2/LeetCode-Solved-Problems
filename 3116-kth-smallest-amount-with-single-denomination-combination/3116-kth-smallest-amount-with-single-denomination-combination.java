import java.util.ArrayList;
import java.util.List;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long minCoin = coins[0];
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        // Binary search range for the kth smallest amount
        long low = 1;
        long high = minCoin * (long) k;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (countAmounts(coins, mid) >= k) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid amount
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private long countAmounts(int[] coins, long target) {
        int n = coins.length;
        long count = 0;
        int totalSubsets = 1 << n;

        for (int mask = 1; mask < totalSubsets; mask++) {
            long currentLcm = 1;
            int bitCount = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bitCount++;
                    currentLcm = lcm(currentLcm, coins[i]);
                    // If LCM exceeds target, floor division target / LCM becomes 0
                    if (currentLcm > target) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (!overflow) {
                if (bitCount % 2 == 1) {
                    count += target / currentLcm;
                } else {
                    count -= target / currentLcm;
                }
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}