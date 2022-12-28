public class NextPermutation {

/*
 * TC=O(n)
 * SC=O(1)
 * 
 */
    public static void nextPermutation(int [] arr){
        int n=arr.length;

        if(arr==null || arr.length<=1){
            return;
        }
        int i=n-2; // to start from the second last ele
        while(i>=0&&arr[i]>=arr[i+1])i--;  // finding the break point i.e is ele which smaller than its next ele
        if(i>=0){ //ensuring ele exist in array
            int j=n-1;
            while(arr[j]<=arr[i])j--;  // finding the next bigger element than arr[i] and than swapping once found
            swap(arr,i,j);
            
        }
        reverse(arr, i+1, n-1); // reversing all elements next to arr[i]
    }

    public static void swap(int [] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void reverse(int []arr,int i,int j){
        while(i<j){
            swap(arr,i++,j--);
        }
    }
    public static void main(String[] args) {

        int [] arr={1,3,5,4,2};
        nextPermutation(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        
    }
    
}
