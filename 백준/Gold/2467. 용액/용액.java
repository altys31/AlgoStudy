import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int left = 0;
		int right = N-1;
		
		int difference = Integer.MAX_VALUE;
		int leftAnswer = list.get(0);
		int rightAnswer = list.get(N-1);
		
		while(true) {
			
			if(left >= right)
				break;
			
			int sum = list.get(left)+list.get(right);
			
			if(sum == 0) {
				leftAnswer = list.get(left);
				rightAnswer = list.get(right);
				break;
			}
			
			if(Math.abs(sum) <= difference) {
				leftAnswer = list.get(left);
				rightAnswer = list.get(right);
				difference = Math.abs(sum);
			};
			
			if(sum <0)
				left++;
			else
				right--;
		}
		System.out.println(leftAnswer+" "+rightAnswer);
	}

}
