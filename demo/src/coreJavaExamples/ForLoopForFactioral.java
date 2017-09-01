package coreJavaExamples;

public class ForLoopForFactioral {

	public static void main(String[] args) {
	
		ForLoopForFactioral obj=new ForLoopForFactioral();

		obj.factioralIncremental();
		
		obj.factioralDecremental();
	
		obj.whileLoopForFactioralIncremental();
		
		obj.whileLoopForFactioralDecremental();

	}
	public void factioralIncremental()
	{
		
		int x=5;
		
		int factioralIncremental=1;
		
		for (int i = 1; i <=x ; i++) 
		{
			factioralIncremental =factioralIncremental*i;
		}
		
		System.out.println(factioralIncremental);
	}
	
	public void factioralDecremental()
	{
		
		int x=5;
		
		int factioralDecremental=1;
		
		for (int i = x; i>=1; i--)
		{
			factioralDecremental=factioralDecremental*i;
			
		}
		
		System.out.println(factioralDecremental);
	}
	
	public void whileLoopForFactioralIncremental()
	{
		int i=1;
		
		int factInc=1;
		
		while(i<=5)
		{
			factInc=factInc*i;
			i++;
		}
		
		System.out.println(factInc);
		
	}
	
	public void whileLoopForFactioralDecremental()
	{
		int i=5;
		
		int factInc=1;
		
		while(i>=1)
		{
			factInc=factInc*i;
			i--;
		}
		
		System.out.println(factInc);
	}
}
