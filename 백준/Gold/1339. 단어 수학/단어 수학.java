
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<String> list =new ArrayList<String>();
		HashMap<String,Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <N; i++) {
			String a = br.readLine();
			char[] b = a.toCharArray();
			int t = b.length-1;
			for(char ch : b) {
				if(map.get(ch+"") != null) {
					map.put(ch+"",map.get(ch+"")+(int)Math.pow(10, t--));
				}
				else
					map.put(ch+"",(int)Math.pow(10, t--));
			}
		}
		
		List<Integer> valuesList = new ArrayList<>(map.values());
		
		Collections.sort(valuesList, Collections.reverseOrder());
		
		int answer = 0;
		int flag = 9;
		for(int i : valuesList) {
			answer += flag--*i;
		}
		
		System.out.println(answer);

		
	}
}
