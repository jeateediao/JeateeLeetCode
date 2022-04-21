package 动态规划;

// 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
// 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1

import java.util.Arrays;

// 比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1
public class _322_零钱兑换 {

    int coinChange01(int[] coins, int amount) {
        return dp01(coins, amount);
    }

    // 定义：要凑出金额 n，至少要 dp[coins, n] 个硬币
    int dp01(int[] coins, int n) {
        // base case
        if (n == 0) return 0;
        if (n < 0) return -1;

        int res = Integer.MAX_VALUE;
        // 做选择，选择需要硬币最少的那个结果
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem  = dp01(coins, n - coin);
            // 子问题无解跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后 +1
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }


    // 带备忘录的递归
    int[] memo;
    int coinChange02(int[] coins, int amount) {
        // 拼凑amount最多使用amount个硬币，全选1元的
        memo = new int[amount + 1];
        // 备忘录初始化为一个不会被取到的特殊值，代表还未被计算
        Arrays.fill(memo, -666);

        return dp02(coins, amount);
    }
    int dp02(int[] coins, int n) {
        // base case
        if (n == 0) return 0;
        if (n < 0) return -1;
        // 查备忘录，防止重复计算
        if (memo[n] != -666) {
            return memo[n];
        }
        int res = Integer.MAX_VALUE;
        // 做选择，选择需要硬币最少的那个结果
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem  = dp02(coins, n - coin);
            // 子问题无解跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后 +1
            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果保存到备忘录
        memo[n] = (res == Integer.MAX_VALUE ? -1 : res);
        return memo[n];
    }


    // 动态规划，至底向上
    // dp数组的定义：当目标金额为i时，至少需要dp[i]枚硬币凑出
    int coinChange03(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1 ,初始值为 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
