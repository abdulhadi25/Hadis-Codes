package Assignment1.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Assignment1.DatabaseConnectionFactory;

@WebServlet("/checkLogin")

public class LoginController extends HttpServlet {
	
    
    private static final long serialVersionUID = 1L;
    
    public LoginController() {
        
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=request.getParameter("username");
		
                String pass=request.getParameter("password");
                
		Connection con=DatabaseConnectionFactory.createConnection();		
		
                ResultSet set=null;
		
                int i=0;
		
                
            try
		{
		 Statement stat = con.createStatement();
		 String sql = "Select * from  users where username='"+user+ "' and password='"+pass+"' ";
		 		System.out.println(sql);
		 set=stat.executeQuery(sql);
		 
                 while(set.next())
		 {
			 i=1;
		 }
                 
		 if(i!=0)
		 {
                     HttpSession session=request.getSession();
		    
                 
                 session.setAttribute("user",user);
			 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsps/home.jsp");
			 rd.forward(request, response);
			 
		 }
		 else
		 {   request.setAttribute("errorMessage","Invalid username/password");
			 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsps/home.jsp");
			 rd.forward(request, response);
		 }
		}
            
            
            catch(SQLException sqe){System.out.println("Error fetching records from database");}
		
            
            
            try
		{
		 con.close();	
		}
            
            
            catch(SQLException se){System.out.println("Error Closing Connection");}
	}
		
		
	

}
