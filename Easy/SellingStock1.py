class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # There are two approaches: Divide and Conquer (return the max profit, max price, and min price 
        # together) in O(n) or Dynamic Programming in O(n).
        #* I will solve by DP here. Note that this is just my "formal" way to solve this with a table
        #* A more efficient approach is below (same idea)
        # dp[m] is the max profit gained from selling and buying within the first m days
        dp = [0]
        
        # Recurrence: dp[m] = max(dp[m-1], prices[m] - min_prices[m-1]) where min_prices(m) is the min price
        # in the first m-1 days
        min_prices = [prices[0]]
        for i in range(1, len(prices)):
            min_prices.append(min(min_prices[i-1], prices[i]))
        
        for m in range(1, len(prices)):
            dp.append(max(dp[m-1], prices[m]-min_prices[m-1]))
            
        return dp[len(prices)-1]
    
        def maxProfitImpr(self, prices):
            # Same idea as DP, but just remember the max for the current day instead of every day
            max_profit = 0
            min_price = prices[0]
            
            for sell_price in prices:
                if sell_price > min_price:
                    max_profit = max(max_profit, sell_price-min_price)
                else:
                    min_price = sell_price
                
            return max_profit