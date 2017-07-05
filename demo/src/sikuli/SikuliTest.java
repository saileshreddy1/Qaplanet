package sikuli;

import org.sikuli.script.App;

import org.sikuli.script.Screen;

public class SikuliTest {

	public static void main(String[] args) throws Exception {
		
		System.out.println("hello");
		App.open("calc.exe");
		System.out.println("hai");
		Screen x=new Screen();
		System.out.println("safdsa");
		if (x.exists("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli")!=null)
		{
			System.out.println("Calci window displayed");
			
		}
		
		x.click("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli\\1.png");
		x.click("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli\\0.png");
		x.click("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli\\2.png");
		x.click("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli\\0 (2).png");
		x.click("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli\\=.png");
		x.click("sdsds\\sadsadas\\dsdsa");
		

	}

}
