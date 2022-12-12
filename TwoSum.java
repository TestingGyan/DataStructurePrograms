import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {


    /*
     * Brute Force
     * 
     * TC: O(n^2)
     * SC: O(1)
     * 
     * 
     */
    public static int[] twoSumB(int [] arr,int target){

        int n=arr.length;
        int []res=new int[2];
        for(int i=0;i<n;i++){ //loop to pick one array element at a time

            for(int j=i+1;j<n;j++){  //loop to check with elements next to picked array element

                if((arr[i]+arr[j])==target){ //comparing sum to target
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;

    }

    






    
    /*
     * Efficient
     * 
     * TC: O(n)
     * SC: O(n)
     * 
     * 
     */
    public static int[] twoSumE(int[]arr,int target){

        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int [] res=new int[2];

        for(int i=0;i<n;i++){
            if(map.containsKey(target-arr[i])){ //checking if map contains target-arr[i]

                res[0]=i;
                res[1]=map.get(target-arr[i]);
                return res;
            }
            map.put(arr[i], i); //Inserting the element as key and index as value in map if target-arr[i] not found
        }
        return res;
    }


    /*
     * TC = O(nlogn)+O(n)
     * 
     * SC=O(1)
     * 
     * 
     */

    public static int [] twoSumTwoPointer(int [] arr,int target){

        int [] res=new int[2];

        int n=arr.length;

        int i=0;
        int j=n-1;

        Arrays.sort(arr);

        while(i<=j){

            if(arr[i]+arr[j]==target){
                res[0]=i;
                res[1]=j;
                return res;
            }
            else if(arr[i]+arr[j]<target){
                i++;
            }
            else if(arr[i]+arr[j]>target){
                j--;
            }

        }

        return res;
    }


    public static void main(String[] args) {


        int [] arr={1,2,5,4,3};
 
        int [] res=twoSumB(arr, 8);
        System.out.println("("+res[0]+","+res[1]+")");

        int [] res1=twoSumE(arr, 8);
        System.out.println("("+res1[0]+","+res1[1]+")");

       int [] res2=twoSumTwoPointer(arr, 8);
       System.out.println("("+res2[0]+","+res2[1]+")");

        
    }
    
}
