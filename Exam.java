package Assignment1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import Assignment1.CreateDOM;

public class Exam {
    
    
	Document dom;
        
	public int currentQuestion=0;	
	
	
	public Map<Integer,Integer> selections=new LinkedHashMap<Integer,Integer>();
	public ArrayList<QuizQuestion> questionList = new ArrayList<QuizQuestion>(10);
	
	public Exam(String test) throws SAXException,ParserConfigurationException,IOException, URISyntaxException{
		dom=CreateDOM.getDOM(test);
	}
	
		
	public void setQuestion(int i)
	{   int num=i;
	String options[]=new String[4];
	    String ques=null;
	    int correct=0;
            
            
	    System.out.println("Dom " + dom);
		NodeList qList=dom.getElementsByTagName("Question");
	    NodeList childList=qList.item(i).getChildNodes();
	    
	    int count=0;
	    
	    for (int j = 0; j < childList.getLength(); j++) {
            Node child = childList.item(j);
            if ("Answer".equals(child.getNodeName()))
            {
                options[count]=childList.item(j).getTextContent();
                count++;
            }
            else if("Quiz Question".equals(child.getNodeName()))
            {
            	ques=childList.item(j).getTextContent();
            }
            else if("Correct".equals(child.getNodeName()))
            {
            	correct=Integer.parseInt(childList.item(j).getTextContent());
            }
            
        }
	    System.out.println("***Retrieving Question***" +num);
		System.out.println("Question: " + ques);
		for(String a:options)
		{
			System.out.println(a);
		}
		System.out.println("Correct answer index : " + correct);
		
		QuizQuestion q=new QuizQuestion();
		q.setQuestionNumber(num);
		q.setQuestion(ques);
		q.setCorrectOptionIndex(correct);
		q.setQuestionOptions(options);
		questionList.add(num,q);
		
	}
	
	
	public ArrayList<QuizQuestion> getQuestionList(){
		return this.questionList;
	}
	
	public int getQuestion(){return currentQuestion;}
	
	public Map<Integer,Integer> getSelections(){
		return this.selections;
	}
	
	public int calcResult(Exam exam){
		
            int totalCorr=0;
            
	
            Map<Integer,Integer> userSelectionsMap=exam.selections;		
	
            List<Integer> userSelectionsList=new ArrayList<Integer>(10);
	
            for (Map.Entry<Integer, Integer> entry :userSelectionsMap.entrySet()) {
			userSelectionsList.add(entry.getValue());
		}
                
            
                
		List<QuizQuestion> questionList=exam.questionList;
	
                List<Integer> correctAnswersList=new ArrayList<Integer>(10);
		
                
                for(QuizQuestion question: questionList){
			correctAnswersList.add(question.getCorrectOptionIndex());
		}
		
                
		for(int i=0;i<selections.size();i++){
			System.out.println(userSelectionsList.get(i)+" --- "+correctAnswersList.get(i));
			if((userSelectionsList.get(i)-1)==correctAnswersList.get(i)){
				totalCorr++;
			}
		}
		
		System.out.println("Number of answers correct: " + totalCorr);	
		
                                
                return totalCorr;
	}

}
