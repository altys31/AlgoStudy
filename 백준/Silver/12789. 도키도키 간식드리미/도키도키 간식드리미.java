import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque<Integer> ();
		Deque<Integer> q2 = new ArrayDeque<Integer> ();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			q.addLast(Integer.parseInt(st.nextToken()));
		}
		
		int startNum = 1;
		
		while(!q.isEmpty() || !q2.isEmpty()) {
			int qLen = q.size();
			int q2Len = q2.size();
			
			if(q2Len > 0) 
				if(q2.peekFirst() == startNum) {
					q2.pop();
					startNum ++;
					continue;
				}
					
			if(qLen > 0) {
				if(q.peekFirst() == startNum) {
					q.pop();
					startNum++;
					continue;
				}
				else 
					q2.push(q.pop());
			}
			
			if(qLen == q.size() && q2Len == q2.size()) {
				System.out.println("Sad");
				return;
			}
		}
		
		System.out.println("Nice");
		
		
	}

}
