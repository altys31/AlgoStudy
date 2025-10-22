import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	static int[] matchCost = {6,2,5,5,4,5,6,3,7,6,6};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N < 16 || N > 46) {
			System.out.println("impossible");
			return;
		}
		
		for(int i = 0; i<= 99; i++) {
			int cost1 = matchCost[i/10] + matchCost[i%10];
			
			for(int j = 0; j <= 99-i; j++) {
				int sum = i+j;
				int cost2 = matchCost[j/10] + matchCost[j%10];
				int cost3 = matchCost[sum/10] +matchCost[sum%10];
				
				if(cost1+cost2+cost3+4 != N)
					continue;
				
				String iText = (i < 10 ? "0" : "") + Integer.toString(i);
				String jText = (j < 10 ? "0" : "") + Integer.toString(j);
				String sumText = (sum < 10 ? "0" : "") +Integer.toString(sum);
				
				System.out.println(iText+"+"+jText+"="+sumText);
				return;
				
			}
		}
		
		System.out.println("impossible");
		
	}

}
