//Problem.java
//holds 1 problem

public class Problem
{
	public ID id;
	public String text = "";
	
	public Problem()
	{
		id = new ID();
		text = "No problem";
	}
	
	public Problem(String text)
	{
		this();
		this.text = text+"";
	}
}