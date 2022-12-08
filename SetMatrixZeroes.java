public class SetMatrixZeroes{


public static void traverseMatrix(int[][]matrix){

        int rows=matrix.length;
        int cols=matrix[0].length;

        for(int i=0;i<rows;i++){

            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }


public static void traverseArray(int[]arr){
    int n=arr.length;
    for(int i=0;i<n;i++){
        System.out.println(arr[i]);
    }
    System.out.println();
} 

/*
 * Brute Force
 * TC=O((N*M)*(N+M))+O(N*M)
 * 
 * SC=O(1)
 * 
 * 
 */
public static void setZeroesN(int[][]arr){

    int rows=arr.length;
    int cols=arr[0].length;

    for(int i=0;i<rows;i++){

        for(int j=0;j<cols;j++){

            if(arr[i][j]==0){

                int colIndex=0;
                while(colIndex<cols){
                    if(arr[i][colIndex]!=0 && arr[i][colIndex]!=-1){
                        arr[i][colIndex]=-1;
                    }
                    colIndex++;
                }

                int rowIndex=0;
                while(rowIndex<rows){
                    if(arr[rowIndex][j]!=0&&arr[rowIndex][j]!=-1){
                        arr[rowIndex][j]=-1;
                    }
                    rowIndex++;
                }

            }

        }
      
    }
    System.out.println("Matrix after inserting -1");
    traverseMatrix(arr);
    for(int i=0;i<rows;i++){

        for(int j=0;j<cols;j++){
            if(arr[i][j]==-1){
                arr[i][j]=0;
            }
        }
    }
    System.out.println("Matrix after inserting zeroes");
    traverseMatrix(arr);


}



/*
 *
 *  Better
 *  TC=O(N*M)+O(N*M) = O(N*M)
 * 
 * SC=O(N)
 * 
 * 
 */

public static void setZeroesB(int[][]arr){

    int rows=arr.length;
    int cols=arr[0].length;

    int []rowsArr=new int[rows];
    int []colsArr=new int[cols];


    for(int i=0;i<rows;i++){

        for(int j=0;j<cols;j++){

            if(arr[i][j]==0){
                if(rowsArr[i]!=-1){
                    rowsArr[i]=-1;
                }
                if(colsArr[j]!=-1){
                    colsArr[j]=-1;
                }
                
            }
        }
    }
    System.out.println("Column array after inserting -1");
    traverseArray(colsArr);
    System.out.println("Rows array after inserting -1");
    traverseArray(rowsArr);

    for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){

            if(arr[i][j]!=0){

                if(rowsArr[i]==-1||colsArr[j]==-1){

                    arr[i][j]=0;
                }
            }
        }
    }

    System.out.println("Matrix after inserting zeroes");

    traverseMatrix(arr);


}


/*
 * Efficient
 * TC=O(N)+O(M)+(N*M)+O(N*M)+O(N)+O(M)= O(N)+O(M)+O(N*M) ~ O(N*M)
 * 
 * SC= O(1)
 * 
 */
public static void setZeroesE(int[][]arr){

    int rows=arr.length;
    int cols=arr[0].length;
    int x=-1;
    int y=-1;

    for(int i=0;i<rows;i++){
        if(arr[i][0]==0){
            x=0;
        }
    }

    for(int j=0;j<cols;j++){
        if(arr[0][j]==0){
            y=0;
        }
    }



    for(int i=1;i<rows;i++){

        for(int j=1;j<cols;j++){

            if(arr[i][j]==0){
                if(arr[i][0]!=0){
                    arr[i][0]=0;
                }

                if(arr[0][j]!=0){
                    arr[0][j]=0;
                }
            }

        }
    }

    for(int i=1;i<rows;i++){

        for(int j=1;j<cols;j++){

            if(arr[0][j]==0||arr[i][0]==0){
                if(arr[i][j]!=0){
                    arr[i][j]=0;
                }
            }
        }
    }

    if(x==0){
        for(int i=0;i<rows;i++){
        if(arr[i][0]!=0){
            arr[i][0]=0;
        }      
        }
    }

    if(y==0){
        for(int j=0;j<cols;j++){
            if(arr[0][j]!=0){
                arr[0][j]=0; 
            }
            
        }
    }
    
    System.out.println("Matrix after inserting zeroes");
    traverseMatrix(arr);
}


public static void main(String[] args) {
    int [][]matrix={{1,1,0,1},{0,1,1,1},{1,0,1,1},{1,1,1,1}};

    System.out.println("Given Matrix");
    traverseMatrix(matrix);
    System.out.println();

    //setZeroesN(matrix);

    //setZeroesB(matrix);

    setZeroesE(matrix);

}

}