package Assignment1.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Assignment1.DatabaseConnectionFactory;


@WebServlet("/checkRegister")

public class RegistrationController extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
       
   
    public RegistrationController() {
         
        super();
        
        
    }

    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	
            String username=request.getParameter("username");
	
            String email=request.getParameter("email");
	
            String password=request.getParameter("pass");
		
		Connection con=DatabaseConnectionFactory.createConnection();
		
		try
		{
		 Statement st=con.createStatement();
		 String sql = "INSERT INTO users values ('" + username + "','" + pass +"','"+ email+"')";
		 		System.out.println(sql);
		 st.executeUpdate(sql);
		}catch(SQLException sqe){System.out.println("Error inserting record in database");}
		try
		{
		 con.close();	
		}catch(SQLException se){System.out.println("Error closing Connection");}
       
                request.setAttribute("newUser",username);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsps/regSuccess.jsp");
		
                dispatcher.forward(request, response);		
	}
	
	
	

}
