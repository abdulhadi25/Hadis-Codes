package Assignment1.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Assignment1.Exam;
import Assignment1.QuizQuestion;

@WebServlet("/exam")


public class ExamController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean fin = false;
		
		HttpSession session=request.getSession();		
		
                try
		{
			if(session.getAttribute("currentExam")==null)
		  {  session=request.getSession(); 	
		     String selectedExam=(String)request.getSession().getAttribute("exam"); 
		     System.out.println("Setting Exam " + selectedExam);
	Exam newExam=new Exam(selectedExam);		  
			   session.setAttribute("currentExam",newExam);
			
                         SimpleDateFormat dateF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
	
                         Date date = new Date();
			 
                         String started=dateF.format(date);
                         
			  session.setAttribute("Started",started);
		  }
		
		}catch(Exception e){e.printStackTrace();}
		
        Exam exam=(Exam)request.getSession().getAttribute("currentExam");		
        
        if(exam.currentQuestion==0){	
			exam.setQuestion(exam.currentQuestion);
		    QuizQuestion q=exam.questionList.get(exam.currentQuestion);	
			session.setAttribute("quest",q);
        }
			
			String action=request.getParameter("action");
			
			String radio=request.getParameter("answer");
			
                        int selected=-1;
			
                        exam.selections.put(exam.currentQuestion, selected);
			if("1".equals(radio))
			{
				selected=1;
				exam.selections.put(exam.currentQuestion, selected);
				System.out.println("You selected "+selected);
			}
			else if("2".equals(radio))
			{
				selected=2;
			
                                exam.selections.put(exam.currentQuestion, selected);
				
                                System.out.println("You selected:" + selected);
			}
			else if("3".equals(radio))
			{
				selected=3;
				exam.selections.put(exam.currentQuestion, selected);
				System.out.println("You selected:" + selected);
			}
			else if("4".equals(radio))
			{
				  selected=4;
	exam.selections.put(exam.currentQuestion, selected);
				
                                System.out.println("You selected: "+selected);
			}
			
						
			if("Next".equals(action)){
				exam.currentQuestion++;
				
                                exam.setQuestion(exam.currentQuestion);
			    QuizQuestion q=exam.questionList.get(exam.currentQuestion);	
			  	session.setAttribute("quest",q);
			}
			else if("Previous".equals(action))
			{   System.out.println("You clicked Previous Button");
				exam.currentQuestion--;
				exam.setQuestion(exam.currentQuestion);
			    QuizQuestion q=exam.questionList.get(exam.currentQuestion);	
				session.setAttribute("quest",q);
			}
			else if("End Exam".equals(action))
			{   fin=true;
                        
				int result=exam.calculateResult(exam);				
				
                          request.setAttribute("result",result);
			request.getSession().setAttribute("currentExam",null);
			request.getRequestDispatcher("/WEB-INF/jsps/result.jsp").forward(request,response);
				
			}
						
		if(fin!=true){
		request.getRequestDispatcher("/WEB-INF/jsps/exam.jsp").forward(request,response);
		}
		
	}

}
