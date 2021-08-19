class Solution {
    public int maxProfit(int[] prices) {
        int buyInd = -1;
        int sellInd = -1;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i =0; i<prices.length;i++){
            if(prices[i] < minPrice){//checking if the present index is the lowest price 
                minPrice = prices[i];//if lowest we buy
                buyInd = i;//store index for later
            }else if(prices[i] - minPrice > maxProfit){//if it is not the lowest price, check to see if we could make more profit on this trade than we have currently
                sellInd = i;//save index like a buy for later lookup
                maxProfit = prices[i]-minPrice; //calclate our current amount of profit
            }
        }
        if(buyInd != -1 && sellInd != -1){//in the other we returned an integer array in this one its just the profit but I added this print statment to essentially do what the other did
                    System.out.println("buyPrice: " + prices[buyInd] + " sellPrice: " + prices[sellInd] + " maxProfit: " + maxProfit);
        }
        return maxProfit;
    }
}
