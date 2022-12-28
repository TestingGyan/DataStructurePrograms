public class StockBuyAndSellProblem {

    //First approach can be using two loops, one to pick and other to traverse through all eles and keeping track of maxProfit


    /*
     * 
     * TC=O(n)
     * SC=O(1)
     * 
     */
    public static int stockBuySell(int [] arr){
        int n=arr.length;

        int minVal=Integer.MAX_VALUE; //intializing min value to max value of integer
        int maxProfit=0;
        for(int i=0;i<n;i++){
            if(arr[i]<minVal){  //updating min value
                minVal=arr[i];
            }
            else if(arr[i]-minVal>maxProfit){ //updating maxProfit
                maxProfit=arr[i]-minVal;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        int arr[] = {7,1,5,3,6,4};
        System.out.println(stockBuySell(arr));
        
    }
    
}
