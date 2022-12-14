import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

/*
 * TC : O(n^3)
 * 
 * Sc : O(n^2)
 * 
 * 
 */
    public static List<List<Integer>> fourSumE(int []arr,int target){

        List<List<Integer>> res= new ArrayList<>();

        int n =arr.length;

        if(arr==null || arr.length==0){ //checking if input array is empty
            return res;
        }
        Arrays.sort(arr);  //sorting array O(nlogn)

        for(int i=0;i<n;i++){  //loop for first ele check

            int target2=target-arr[i]; 

            for(int j=i+1;j<n;j++){ //loop for second ele check

                int target3=target2-arr[j]; //target which will be sum of remaining two elements in quad if i & j are first two eles
                int front=j+1; 
                int back=n-1;

                while(front<back){ // applying two sum approach to find remaining elemnts in quad with respect to first (i) and second ele (j)
                    int twoSum=arr[front]+arr[back];

                    if(twoSum<target3){
                        front++;
                    }
                    else if(twoSum>target3){
                        back--;
                    }
                    else{
                        List<Integer> quad=new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add((arr[j]));
                        quad.add((arr[front]));
                        quad.add(arr[back]);
                        res.add(quad);

                        while(front<back && quad.get(2)==arr[front])++front;  // ensuring to skip duplicates of third ele in quad
                        while(front<back && quad.get(3)==arr[back])--back; //ensuring to skip duplicates of fourth ele in quad
                    }
                }

                while(j+1<n && arr[j]==arr[j+1])++j; //ensuring to skip duplicates of second ele in quad
                //here j+1 ensure to rech last dupliacte as j will also be incremented in for loop
                
            }

            while(i+1<n && arr[i+1]==arr[i])++i;//ensuring to skip duplicates of first ele in quad
            //here i+1 ensure to rech last dupliacte as i will also be incremented in for loop
        }

        return res;
    }


    public static void main(String[] args) {
        
        int [] arr={1,0,-1,0,-2,2};
        int target=0;

        List<List<Integer>>res=fourSumE(arr, target);

        for (List<Integer> list : res) {

            System.out.println(list);
            
        }
    }
    
}
