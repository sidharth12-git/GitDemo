import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenNosFilterWithoutStream {

	public static void main(String[] args) {

		List<Integer> listNumbers = Arrays.asList(10,15,20,25,30);
		ArrayList<Integer> evenNosList =  new ArrayList<Integer>();
		//without using streams
		for(int n : listNumbers)
		{
			if(n%2==0)
			{
				evenNosList.add(n);
			}
		}
		System.out.println(evenNosList);

	}

}
