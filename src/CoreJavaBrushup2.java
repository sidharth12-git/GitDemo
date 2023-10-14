
public class CoreJavaBrushup2 {

	public static void main(String[] args) {
		//declaring String using String literal
		String s = "Rahul Shetty Academy";
		String s1 = "Rahul Shetty Academy";
		
		//declaring String using new operator
		
		String s2= new String("Welcome");
		String s3= new String("Welcome");
		
		String s4= "Rahul Shetty Academy";
		
		String[] splittedString = s4.split(" ");
		for(int i=0; i<splittedString.length;i++)
		{
			System.out.println(splittedString[i]);
		}
		
		System.out.println("**************************");
		for(int i =0; i< s4.length();i++)
		{
			System.out.println(s.charAt(i));
		}
				
		System.out.println("**************************");
		for(int i =s4.length()-1; i>=0;i--)
		{
			System.out.println(s.charAt(i));
		}
		System.out.println("******Rev Inner words*******");
		
		String s5= "Rahul Shetty Academy";
		System.out.println("Original String : " + s5);
		String revInnerString="";
		
		
		String[] splitString = s5.split(" ");
		for(int i=0; i<splitString.length;i++)
		{
			for(int j=splitString[i].length()-1; j>=0 ;j--)
			{
				revInnerString = revInnerString + splitString[i].charAt(j);
				
			}
			revInnerString = revInnerString + " ";
			
		}
		System.out.println("String after inner reverse of words : " + revInnerString);

	}

}
