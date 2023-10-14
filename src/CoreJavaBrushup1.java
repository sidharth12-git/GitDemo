import java.util.ArrayList;
import java.util.Arrays;

public class CoreJavaBrushup1 {

	public static void main(String[] args) {
		int myNum = 5;
		String website = "Rahul Shetty Academy";
		char letter = 'S';
		double dec = 5.99;
		boolean myCard = true;

		System.out.println(myNum + " is the value stored in this variable");
		System.out.println(website);

		// Arrays

		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 5;
		arr[4] = 6;

		// 1st method - traversing array using enhanced for loop
		for (int element : arr) {
			System.out.println("Printing array: " + element);
		}

		System.out.println();
		// 2nd method - traversing array using normal for loop
		int[] arr2 = { 11, 12, 13, 14, 15 };
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("Printing array2: " + arr2[i]);
		}

		System.out.println();
		// 3rd method - Arrays.asString(array)

		// declaring and initializing array
		int array[] = { 34, -10, 56, -9, -33 };
		// returns string representation of the specified array
		System.out.println(Arrays.toString(array));
		
		System.out.println();
		
		//traversing string array
		
		String[] strArray = {"sid","bhatia","cricket", "football"};
		for(String str : strArray)
			System.out.println(str);
		
		//Print multiple of 2 and not multiple of 2
		
		int[] array5 = {1,2,3,4,5,6,7,12,11,8,15,13,14,17,16};
		for (int arr6 : array5)
			if(arr6 % 2 == 0)
			{
				System.out.println("Multiple of 2 nos: " + arr6);
				break;
			}
			else
			{
				System.out.println("Not Multiple of 2 nos: " + arr6);
			}
		
		//ArrayList concept
		
		ArrayList<String> aList= new ArrayList<String>();
		aList.add("Sid");
		aList.add("Bhatia");
		aList.add("Selenium");
		aList.add("Cypress");
		aList.remove(0);
		System.out.println(aList.get(2));
		System.out.println(aList.get(0));
		
		//traversing ArrayList using normal for loop
		for (int i=0; i< aList.size();i++)
		{
			System.out.println(aList.get(i));
		}
		
		System.out.println("***************************");
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(4);
		a.add(6);
		a.add(8);
		a.add(6);
		
		//traversing ArrayList using enhanced for loop
		for (Integer aList1 : a)
		{
			System.out.println(aList1);
		}
		
		//item is present in ArrayList or not
		
		System.out.println(aList.contains("selenium"));
		System.out.println(aList.contains("Selenium"));
		System.out.println(aList.contains("Sid"));
	}

}
