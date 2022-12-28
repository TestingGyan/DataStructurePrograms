public class SortArray012 {


    // First approach will be to use sorting algorythm -- TC =O(nlogn)

    //Second approach is to count zeroes, 1s and 2s and than running loops based on count to insert the eles in array in correct positions
    // i.e is first inserting 0s than 1s and than 2s
    

    public static int [] sort(int [] arr){
        int n=arr.length;
        int l=0;
        int m=0;
        int h=n-1;

        while(m<=h){
            switch(arr[m]){
                case 0:{
                    swap(arr,l++,m++);
                    break;
                }
                case 1:{
                    m++;
                    break;
                }
                case 2:{
                    swap(arr,m,h--);
                    break;
                }
            }
        }
        return arr;
    }
    public static void swap(int [] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        
        int [] arr={0,1,0,1,2,1,1,0,2,2,0,1,1};

        arr=sort(arr);

        for (int i : arr) {
            System.out.print(i);
        }
    }
    
}
