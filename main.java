/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import static factorial.Factorial.fact;
import java.util.Scanner;

/**
 *
 * @author aaamir.bscs15seecs
 */
public class main {
    public static void main(String args[]){
            Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the number to get its factorial:");
          int num = scanner.nextInt();
           int factorial = fact(num);
      System.out.println("Factorial of inputed number is: " + factorial);
   }
    
}
