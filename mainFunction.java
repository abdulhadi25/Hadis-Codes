
package iterativemethod;
import java.util.Scanner;
public class mainFunction extends IterativeMethod{
    
    public static void main(String[] args) {
     int row, col, row1, col1, sum = 0, i, j, k;
 
      Scanner in = new Scanner(System.in); // for input
      // row and col count intialization of first matrix
      System.out.println("Enter the number of rows of first matrix");
      row = in.nextInt();
      System.out.println("Enter the number of columns of first matrix");
      col = in.nextInt();
 
      int first[][] = new int[row][col];
    // row and col value intialization of first matrix
      System.out.println("Enter the elements of first matrix");
 
      for ( i = 0 ; i < row ; i++ )
         for ( j = 0 ; j < col ; j++ )
            first[i][j] = in.nextInt();
      
   // row and col count intialization of second matrix
      System.out.println("Enter the number of rows of second matrix");
      row1 = in.nextInt();
      System.out.println("Enter the number of columns of first matrix");
      col1 = in.nextInt();
 
      if ( col != row1 )
         System.out.println("Matrices with entered orders can't be multiplied with each other.");
      else
      {
         int second[][] = new int[row1][col1];
         int multiply[][] = new int[row][col1];
 
         System.out.println("Enter the elements of second matrix");
 
         for ( i = 0 ; i < row1 ; i++ )
            for ( j = 0 ; j < col1 ; j++ )
               second[i][j] = in.nextInt();
      // Create object to interface with other class 
    IterativeMethod im= new IterativeMethod();
    GetIM(second,multiply); 
    
    
    
    
    
    }
    }
}
