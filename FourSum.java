import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {


    public static List<List<Integer>> fourSumE(int [] arr,int target){

        ArrayList<List<Integer>> res= new ArrayList<>();

        int n=arr.length;
        
        Arrays.sort(arr);
        for(int i=0;i<n;i++){

            int target2=target-arr[i];

            for(int j=0;j<n;j++){
                int target3=target2-arr[j];
                int front = j+1;
                int back = n-1;

                while(front<back){
                    int two_sum=arr[front]+arr[back];
                    if(two_sum<target3){
                        front++;
                    }
                    else if(two_sum>target3){
                        back--;
                    }
                    else{
                        List<Integer> quad=new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[front]);
                        quad.add(arr[back]);
                        res.add(quad);

                        while(front<back && quad.get(2)==arr[front])++front;
                        while(front<back && quad.get(3)==arr[back])--back;
                    }

                }

                while(j+1<n&&arr[j]==arr[j+1])++j;

            }

            while(i+1<n&&arr[i]==arr[i+1])++i;
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
    
}
