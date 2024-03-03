
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list= new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		list.sort(null);
		
		perm(0,new int[M],0,bw);
		bw.close();
		
	}
	static void perm(int toselect,int[] nums, int startidx,BufferedWriter bw) throws IOException {
		if(toselect == M) {
			for(int a: nums) {
				bw.append(Integer.toString(a)).append(" ");
			}
			bw.append("\n");
			return;
		}
		HashSet<Integer> set = new HashSet<>();
		
		for(int i = startidx; i<N; i++) {
			if(!set.contains(list.get(i))) {
				set.add(list.get(i));
				nums[toselect] = list.get(i);
				perm(toselect+1,nums,i,bw);
			}
		}
		
	}

}
