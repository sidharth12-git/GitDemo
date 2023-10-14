import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumNumbersStream {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3,9,12,16,20,24,28,30);
		Optional<Integer> sum  = list.stream().reduce((a,b)-> a+b);
		System.out.println("Sum of Numbers: " + sum.get());
				

	}

}
