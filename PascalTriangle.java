import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> printPascal(int numRows){

        List<List<Integer>> res=new ArrayList<>();

        List<Integer> row,prev=null;

        for(int i=0;i<numRows;i++){

            row=new ArrayList<>();

            for(int j=0;j<=i;j++){

                if(j==0 || j==i){
                    row.add(1);
                }
                else{
                    row.add(prev.get(j)+prev.get(j-1));
                }

                
            }
            prev=row;
            res.add(row);
        }

        return res;
    }

    public static void main(String[] args) {

        List<List<Integer>> res=printPascal(4);

        for (List<Integer> list : res) {
            System.out.println(list);
        }
        
    }
    
}
