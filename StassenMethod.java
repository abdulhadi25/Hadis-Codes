package stassenmethod;
import java.util.Scanner;
public class StassenMethod {

    public static void multiply (int[][] A, int[][] B, int [][]C, int N ) {
    int p1, p2, p3, p4, p5, p6 ,p7;
    p1= A[0][0]*(B[0][1]-B[1][1]);
    p2=(A[0][0]+A[0][1])*B[1][1];
    p3=(A[1][0]+A[1][1])*B[0][0];
    p4=A[1][1]*(B[1][0]-B[0][0]);
    p5=(A[0][0]+A[1][1])*(B[0][0]+B[1][1]);
    p6=(A[0][1]-A[1][1])*(B[1][0]+B[1][1]);
    p7=(A[0][0]-A[1][0])*(B[0][0]+B[0][1]);
    C[0][0]=p5+p4-p2+p6;
    C[0][1]=p1+p2;
    C[1][0]=p3+p4;
    C[1][1]=p1+p5-p7-p3;
}
    
    public static void main(String[] args) 
     { 
           int N =2;
           int [][]data1 = {{1,2}, {1,2}};
           int [][]data2 = {{1,2}, {1,2}};
           int[][] data3= new int[N][N];
           
           multiply(data1, data2, data3, N); 
           for(int i = 0; i<N; i++) {
                for(int j = 0; j<N; j++)
                {
                 System.out.print(data3[i][j] + " ");
                 }
                 System.out.println();
                }
     }     
}