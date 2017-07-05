package whileloop;

public class FactorialDecremention {

	public static void main(String[] args) {

		int i=5;
		int fact=1;
		
		while(i>=1)
		{
			
			fact=fact*i;
			i--;
		}
		System.out.println(fact);

	}

}
