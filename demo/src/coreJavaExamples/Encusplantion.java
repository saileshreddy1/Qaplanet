package coreJavaExamples;

class EncapTest
{
	   private String name;
	   
	   private String idNum;
	   
	   private int age;

	   public int getAge() 
	   {
	   
		   return age;
	   }
	   
	   public String getName() 
	   {
	      return name;
	   }

	   public String getIdNum() 
	   {
	      return idNum;
	   }

	   public void setAge( int newAge) 
	   {
	      age = newAge;
	   }

	   public void setName(String newName) 
	   {
	      name = newName;
	   }

	   public void setIdNum( String newId) 
	   {
	      idNum = newId;
	   }
}

public class Encusplantion {

	public static void main(String [] args) {
	
		  EncapTest encap = new EncapTest();
	      encap.setName("James");
	      encap.setAge(20);
	      encap.setIdNum("12343ms");
	           
	      System.out.println(encap.getName());
	      System.out.println(encap.getAge());
	      System.out.println(encap.getIdNum());
	     
	      
	}

}
