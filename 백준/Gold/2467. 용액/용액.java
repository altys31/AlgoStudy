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
		int[] array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			array[i]  = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		
		int difference = Integer.MAX_VALUE;
		int leftAnswer = array[0];
		int rightAnswer = array[N-1];
		
		while(true) {
			
			if(left >= right)
				break;
			
			int sum = array[left]+array[right];
			
			if(sum == 0) {
				leftAnswer = array[left];
				rightAnswer = array[right];
				break;
			}
			
			if(Math.abs(sum) <= difference) {
				leftAnswer = array[left];
				rightAnswer = array[right];
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


