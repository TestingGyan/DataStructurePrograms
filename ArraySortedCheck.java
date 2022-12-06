public class ArraySortedCheck{


/*
 * TC : O(n^2)
 * 
 * SC : O(1)
 * 
 */
public static boolean isSortedNaive(int [] arr){

    int n = arr.length;
    
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(arr[j]<arr[i]){
                return false;
            }
        }
    }

    return true;

}

/*
 * TC = O(n)
 * 
 * SC = O(1)
 * 
 */
public static boolean isSortedEfficient(int [] arr){

    int n = arr.length;

    for(int i=1;i<n;i++){
        if(arr[i]<arr[i-1]){
            return false;
        }
    }
    return true;
}

    public static void main(String[] args) {

        int [] arr = {1};

        System.out.println(isSortedNaive(arr));

        System.out.println(isSortedEfficient(arr));

        
    }

}