class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # The idea here is whenever we see that the price is increasing, we would buy from previous day
        # then sell immediately the day after. Think of this as adding all the "upward trend" in a graph.
        profit = 0
        for i in range(len(prices)-1):
            if prices[i+1] > prices[i]:
                profit += prices[i+1] - prices[i]
        
        return profit