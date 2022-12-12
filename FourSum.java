import java.util.ArrayList;
import java.util.List;

public class FourSum {


    public static List<List<Integer>> fourSumE(int [] arr, int target){

        List<List<Integer>> res=new ArrayList<>();

        int n=arr.length;

        for(int i=0;i<n;i++){

            int target2=target-arr[i];

            for(int j=i+1;j<n;j++){

                int target3=target2-arr[j];

                int front=j+1;
                int back=n-1;

                while(front<back){
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
                        quad.add(arr[j]);
                        quad.add(arr[front]);
                        quad.add(arr[back]);
                        res.add(quad);

                        while(front<back && quad.get(2)==arr[front])++front;

                        while(front<back && quad.get(3)==arr[back])--back;

                    }
                }
                while(j+1<n&&arr[j+1]==arr[j])++j;
            }

            while(i+1<n&&arr[i+1]==arr[i])++i;
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
