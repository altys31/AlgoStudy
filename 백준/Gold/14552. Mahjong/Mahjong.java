import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] array;
	static Set<Integer> answer;
	static int[] numCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		array = new int[13];
		
		answer = new HashSet<> ();
		
		numCount = new int[10];
		
		for(int i = 0; i<13; i++) {
			int num = Integer.parseInt(st.nextToken());
			numCount[num] += 1;
			array[i] = num;
		}
		
		int [] torso = new int[3];
		
		boolean[] visited = new boolean[13]; 
		
		combination(visited, 0, torso,0,0,0);
		
		for(int a : answer) {
			System.out.print(a+" ");
		}
		
		if(answer.size() == 0) {
			System.out.println("-1");
		}
	
		
	}
	
	static void combination(boolean[] visited, int level, int[] combi, int start, int torso, int head) {

		//몸통 대기
		if(torso == 3 && head == 1 && level == 2) {

			for(int i = 1; i <10; i++) {
				combi[2] = i;
				if(checkTorso(combi) && numCount[i] != 4) 
					answer.add(i);
			}
			return;
		}
		
		//머리대기
		if(torso == 4 && head == 0 && level == 1) {
			for(int i = 1; i<10; i++) {
				combi[1] = i;
				if(checkHead(combi)&& numCount[i] != 4) {
					answer.add(i);
				}
			}
			return;
			
		}
		
		if(head == 6 && level == 1) {
			for(int i = 1; i<10; i++) {
				combi[1] = i;
				if(checkHead(combi) && numCount[i] != 3) {
					answer.add(i);
				}
			}
			return;
		}
		

		if(level == 2 && !(torso > 0  &&  head > 0) && checkHead(combi)) {
			combination(visited,0, new int[3], 0, torso, head+1);
		}
		
		if(level == 3 && torso < 4 && checkTorso(combi)) {
			combination(visited, 0, new int[3], 0, torso+1,head);
		}
		
		for(int i = start; i<13; i++) {
			
			if(!visited[i] && level < 3) {
				combi[level] = array[i];
				visited[i] = true;
				combination(visited, level+1, combi, i, torso, head);
				combi[level] = -1;
				visited[i] = false;
			}
			
		}
		
	}
	
	static boolean checkTorso(int[] array) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i =0; i<3; i++) {
			if(array[i] == -1) 
				return false;
			list.add(array[i]);
		}
		
		list.sort(null);
		
		if(list.get(0)==list.get(1) && list.get(1) == list.get(2))
			return true;
		
		if(list.get(0) - list.get(1) == -1 && list.get(1) - list.get(2) == -1)
			return true;
		
		return false;
		
	}
	static boolean checkHead(int[] array) {
		if(array[0] == array[1]) 
			return true;
		else 
			return false;
		
	}
}
