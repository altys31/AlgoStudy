import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int answer = 0;
		int temp;
		int kinds = 0;
		int pt;
		
		int[] sushi_num = new int[d+1];
		
		for(int i = 0; i<N; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		sushi_num[c] = 1;
		kinds = 1;
		
		for(int i = 0; i<k; i++) {
			pt = i;
			if(pt >= N)
				pt %= N;
			if(sushi_num[arr[pt]] == 0)
				kinds++;
			sushi_num[arr[pt]]++;
//			System.out.println("pt : " + pt + ", arr[pt] : " + arr[pt] + ", sushi_num :  "+sushi_num[arr[pt]]);
		}
		
		answer = Math.max(kinds, answer);
		

		temp = arr[0];
		
		for(int i = k; i<=N+k; i++) {
			pt = i;
			if(pt >= N)
				pt %= N;
//			System.out.println("pt : " + pt + ", arr[pt] : " + arr[pt] + ", sushi_num :  "+sushi_num[arr[pt]]);
			
			sushi_num[temp]--;
			
			if(sushi_num[temp] == 0)
				kinds--;
			
			if(sushi_num[arr[pt]] == 0)
				kinds++;
			
			sushi_num[arr[pt]]++;
//			System.out.println("sushi : " + arr[pt] +  " kind  : "+ kinds);

			
			answer = Math.max(kinds, answer);
			
			if(pt-k+1 < 0)
				pt += N;
			temp = arr[pt-k+1];
			
//			for(int n = 1; n <= d; n++) {
//				if(sushi_num[n] > 0)
//					System.out.print(n+ " ");
//			}
//			System.out.println();
//			System.out.println("=================");
			
		}
		
		System.out.println(answer);
	}

}