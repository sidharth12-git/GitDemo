import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNosFilterWithStream {

	public static void main(String[] args) {
		List<Integer> numbersList = Arrays.asList(10,15,20,25,30,35,40);
		
		
		//if want to store data in another arraylist
//		evenNosList = numbersList.stream().filter(n->n%2==0).collect(Collectors.toList());
//		System.out.println(evenNosList);
		
		//if dont want to store in another arraylist, just want to print in console
		//numbersList.stream().filter(n->n%2==0).forEach(n->System.out.println(n));
		long evenNosCount = numbersList.stream().filter(n->n%2==0).count();
		System.out.println(evenNosCount);
		
		

	}

}
