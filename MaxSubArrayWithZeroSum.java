import java.util.HashMap;

public class MaxSubArrayWithZeroSum {

    /*
     * TC=O(n^2)
     * SC=O(n)
     * 
     */
    public static int maxSumB(int [] arr){
        int n=arr.length;

        int res=0;

        for(int i=0;i<n;i++){
            int currSum=0;
            for(int j=i;j<n;j++){
                currSum+=arr[j];
                if(currSum==0){
                    res=Math.max(res, j-i+1);
                }
            }
        }
        return res;
    }

    /*
     * TC=O(nlogn)
     * SC=O(n)
     * 
     * 
     */

    public static int maxSumE(int [] arr){
        int n=arr.length;

        HashMap<Integer,Integer> map=new HashMap<>();

        int maxi=0;
        int sum=0;

        for(int i=0;i<n;i++){

            sum+=arr[i];
            if(sum==0){
                maxi=i+1;
            }
            else{
                if(map.get(sum)!=null){
                    maxi=Math.max(maxi, i-map.get(sum));
                }else{
                    map.put(sum, i);
                }
                
            }

        }
        return maxi;
    }

    public static void main(String[] args) {
        
        int [] arr={1,2,4,-2,-4};


        System.out.println(maxSumB(arr));

        System.out.println(maxSumE(arr));

    }
    
}
