//ProblemSolution.java
//holds 1 problem and >=1 solutions

import java.util.ArrayList;

public class ProblemSolution
{
	public Problem problem = new Problem();
	public ArrayList<Solution> solutions = new ArrayList<Solution>();
	public int selectedSolution = 0;		//the currently selected solution
	
	public ProblemLine innerLine = new ProblemLine();
	
	public ProblemSolution()
	{
		solutions.add(new Solution());
	}
	
	public void addSolution(Solution solution)
	{
		
	}
	
	//return true if ProblemLine line is the same as the innerLine
	public boolean hasLine(ProblemLine line)
	{
		return (line == innerLine);
	}
}
