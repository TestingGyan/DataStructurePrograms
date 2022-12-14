import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    /*
     * 
     * TC : O(n^2), as we are traversing to create a 2 d array across rows and cols based on input
     * 
     * SC : O(n^2), as we are storing result in List of List
     *  
     * 
     */
    public static List<List<Integer>> printPascal(int n){

        List<List<Integer>> res=new ArrayList<>();

        List<Integer> row,prev=null;

        for(int i=0;i<n;i++){  //loop for rows

            row=new ArrayList<>();  // intializing list to store col elements of one row
  
            for(int j=0;j<=i;j++){  //loop for columns, that is why j<=i as in 2nd row there will be 2 eles or columsns, in 3 row there will be 3 like so

                if(j==0 || j==i){ //as first and last ele of row will always be 1 in pascal triangle so inserting 1 in row
                    row.add(1);
                }
                else{
                    row.add(prev.get(j)+prev.get(j-1)); //else it will be sum of prev row ele in current col and one col behind 
                }          
            }
            prev=row; //updating prev row for next traversal
            res.add(row); //addingthe created row in resultant list 
        }
        return res;
    }

    public static void main(String[] args) {

        List<List<Integer>> res=printPascal(2);

        for (List<Integer> list : res) {
            System.out.println(list);
        }
        
    }
    
}
