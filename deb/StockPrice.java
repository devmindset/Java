package deb;

/**
 * 
 * @author debojyoti.sarkar
 *1.	Programming Problem 
	Given a set of time-ordered stock prices, compute the MAX profit that one can make from it. The maximum profit one can make is by buying at the lowest price in the set and selling at the highest price
	The program should accept a list of stock prices and return 3 values - (a) the stock buy price (b) the stock sell price (c) the max profit that can be made from this set
	The important constraint in the problem is the time-ordering. One cannot sell a stock before buying it. So the transaction has to be always buy-first, and then followed by a sell
	Here are couple of examples: 
	$ java stock 1 3 5 7 3 2 6 8 0 1 4 7
	The max profit you can make is = 7 by buying at value of 1 and selling at 8
	$ java stock 5 4 3 2 1
	You CANNOT make a positive profit with this data set
	$ java stock 1 2 3 4 5
	The max profit you can make is = 4 by buying at value of 1 and selling at 5
	The program should be able to run on at least ONE MILLION data points on a laptop
	You can assume all input numbers to be integers. But you will get a bonus point if you can write the program to accept both integers and float's
	General instructions 
	Program should be in Java or Scala
Send a README note on how to run the program
	Describe the order-of-complexity (big-O notation) that you think your program will be able to run in (will it run in linear time? Logrithmic time? Exponential?)
Send the response by Monday 6th June 9AM 
	Please ask any doubts/questions asap

 *
 */


public class StockPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String str = "2 2 6 5 1 4"; 
        		 //"7 0 6 0 2 9 11 5 21";
        		 //"8 8 8 8 8"; 
        		 //"5 4 3 2 1"; 
        		 //"1 3 5 7 3 2 6 8 0 1 4 7";
         String[] arr = str.split("\\s+");
         String[] intArr = str.split("\\s+");
         if(arr.length==0){
        	 System.out.println("No Profit you can make"); 
         }
         int buyPrice = 0;
         int buyDate = 1;
         int sellDate =0;
         int minVal = 0;
         int sellPrice= 0;
         int maxDiff = 0;
         int diff = 0;
         int len =arr.length;
         minVal = Integer.parseInt(intArr[0]);
         for(int i=1;i<len;i++){
        	 int w = Integer.parseInt(intArr[i]);
             if(minVal>w && w!=0){
            	minVal = w;
            	continue;
             }
             diff = w - minVal;
             if(diff>maxDiff){
            	buyDate = i;
            	buyPrice = minVal;
            	maxDiff = diff;
            	sellDate = i+1;
            	sellPrice = w;
             }
          }
           if(sellDate == 0 ){
        	   System.out.println("No Profit you can make");
           } else {
        	   System.out.println("Buy Date = "+buyDate +" Price = "+buyPrice);
        	   System.out.println("Sell Date = "+sellDate +" Price = "+sellPrice);
           }
         
         
         
	}

}
