/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aaamir.bscs15seecs
 */
public class mainStackTest {
    
    public mainStackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class mainStack.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        mainStack.main(args);
        
    stack = new String[100];
    next_index = 0;
  }

  public String pop() {
    return stack[--next_index];
  }

  public void delete(int n) {
    next_index -= n;
  }

  public void push(String aString) {
    stack[next_index++] = aString;
  }

  public String top() {
    return stack[next_index - 1];
  }

  public void checkInvariant() throws Exception {
    if (!(next_index >= 0 && next_index < stack.length)) {
      throw new Exception("next_index out of range: " + next_index + " for stack length "
          + stack.length);
    }
  }

  private int next_index;

  private String[] stack;
        
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    

