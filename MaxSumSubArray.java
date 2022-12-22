public class MaxSumSubArray {

    /*
     * TC=O(n)
     * SC=O(1)
     * 
     * 
     */
    public static int maxSumB(int [] arr){

        int n=arr.length;
        int maxSum=arr[0];
        for(int i=0;i<n;i++){
            int currSum=0;
            for(int j=i;j<n;j++){
                currSum+=arr[j];
                maxSum=Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    public static int maxSumE(int [] arr){
        int n=arr.length;

        int prevMaxSum=arr[0];
        int res=arr[0];
        for(int i=1;i<n;i++){
            prevMaxSum=Math.max(prevMaxSum+arr[i], arr[i]);
            res=Math.max(prevMaxSum, res);
        }
        return res;
    }
    
    public static void main(String[] args) {

        int []arr={1,-1,2,3,5,-2,7,-5};

        System.out.println(maxSumB(arr));
        System.out.println(maxSumE(arr));
        
    }
}
