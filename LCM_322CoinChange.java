import java.util.Arrays;

class LCM_322CoinChange {
     public static int coinChange(int[] coins, int amount) {
         int[] dp = new int[amount + 1];
         Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
     }

     public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int amount = 99;
        System.out.println(LCM_322CoinChange.coinChange(coins, amount));
     }
 }