package Assignment1;

public class QuizQuestion {
	
	int questionNum,correctOptInd;
	String ques, questionOpt[];
		
	
	public String getQuestion()
	{ 
		return ques;
	}
	
	public int getQuestionNum()
	{
		return questionNum;
	}
	
	public void setQuestionNum(int i)
	{
		questionNum = i;
	}
	
	public int getCorrectOptIndex()
	{
		return correctOptInd;
	}
	
	public String[] getQuestionOpt()
	{
		return questionOpt;
	}
	
	public void setQuestion(String sq)
	{
		ques=sq;
	}
	public void setCorrectOptIndex(int ind)
	{
		correctOptInd = ind;
	}
	public void setQuestionOpt(String[]sqo)
	{
		questionOpt = sqo;
	}

}
