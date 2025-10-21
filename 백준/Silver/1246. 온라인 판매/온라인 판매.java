import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> pList = new ArrayList<Integer>();
		
		for(int i = 0; i<M; i++) {
			pList.add(Integer.parseInt(br.readLine()));
		}
		
		pList.sort((o1, o2) -> o2-o1);
		
		//System.out.println(pList.toString());
		int answerPrice = 0;
		int answerProfit = 0;
		
		for(int i = 0; i < (N < M ? N : M); i++) {
			int sum = (i+1) * pList.get(i);
			if(answerProfit <= sum) {
				answerPrice = pList.get(i);
				answerProfit = sum;
			}
		}
		
		System.out.println(answerPrice+ " " + answerProfit);
		
	}
}
