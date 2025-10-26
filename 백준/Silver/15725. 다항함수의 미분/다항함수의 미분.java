import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String polynomial = br.readLine();
		
		if(!polynomial.contains("x")) {
			System.out.println("0");
			return;
		}

		String[] split = polynomial.split("x");
		String value = "";
		if(split.length > 0)
			value = polynomial.split("x")[0];
		
		if(value.equals("-")){
			System.out.println("-1");
			return;
		}
		
		System.out.println(value.length() == 0 ? "1" : value);
	}

}
