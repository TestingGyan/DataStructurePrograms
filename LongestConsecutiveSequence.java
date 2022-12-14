import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence{



    /*
     * 
     * TC : O(nlogn)+O(n)
     * SC : O(1)
     * 
     */
    public static int sequenceNaive(int [] arr){

        int n=arr.length;

        int res=1;

        int length=1;

        Arrays.sort(arr);

        for(int i=0;i<n-1;i++){

            if(arr[i]==arr[i+1]-1){
                length++;
            }else{    
              length=1;
            }
            res=Math.max(length, res);

        }

        return res;
    }


    /*
     * TC = O(n)
     * SC = O(n)
     * 
     * 
     */
    public static int sequenceE(int []arr){

        int res=1;

        Set<Integer> s=new HashSet<>();

        //storing array eles in set
        for(int i=0;i<arr.length;i++){ /* TC=O(n) */
            s.add(arr[i]); /*Sc=O(n) */
        }

        //TRaversing through set
        for(int i=0;i<s.size();i++){ /*TC=O(n) */
            
            if(!s.contains(arr[i]-1)){ /*TC=O(n) */ //check to find the minimum ele of a sequence
                int length=1;
                while(s.contains(arr[i]+length)){ //loop to check if ele next to minimum ele exist and increment length of sequence
                    length++;
                }
                res=Math.max(res, length);  
            }
        }
        return res;

    }

public static void main(String[] args) {

int [] arr={1,3,2,4,5,100,99,98,101,102,103};

System.out.println(sequenceNaive(arr));

System.out.println(sequenceE(arr));
}

}

