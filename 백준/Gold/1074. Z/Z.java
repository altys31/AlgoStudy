import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer = 0;
	static int r;
	static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		divide(1<<N,0,0);
		System.out.println(answer);
		
	}
	
	static void divide(int N, int x, int y) {
		
		
		if(N==1) {
			return;
		}
		
		int nN = N/2;
		
		if(r< y+ nN && c<x +nN) {
			divide(nN,x,y);
		}
		if(r<y+nN && c>= x+nN) {
			answer += ((N*N)/4);
			divide(nN,x+nN,y);
		}
		if(r>= y+nN && c<x+nN){
			answer += ((N*N)/4)*2;
			divide(nN,x,y+nN);
		}
		if(r>= y+nN && c>=x+nN) {
			answer+=((N*N)/4)*3;
			divide(nN,x+nN,y+nN);
		}
		
	}
}