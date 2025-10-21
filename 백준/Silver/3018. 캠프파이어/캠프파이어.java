import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		Set<Integer> allSongSet = new HashSet<Integer>();
		ArrayList<Set<Integer>> heardSongList = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			heardSongList.add(new HashSet<Integer>());
		}
		
		for(int i = 0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			
			boolean isSunyoung = false;
			int[] participants = new int[K];
					
			for(int j = 0; j<K; j++) {
				int personNum = Integer.parseInt(st.nextToken());
				
				if(personNum == 1)
					isSunyoung = true;
				
				participants[j] = personNum;
			}
			
			if(isSunyoung) {
				allSongSet.add(i);
				for(int j = 0; j<K; j++) {
					heardSongList.get(participants[j]-1).add(i);
				}
			}
			else {
				Set<Integer> sumSet = new HashSet<Integer>();
				
				for(int j= 0; j<K; j++) {
					sumSet.addAll(heardSongList.get(participants[j]-1));
				}
				
				for(int j = 0; j<K; j++) {
					heardSongList.get(participants[j]-1).addAll(sumSet);
				}
			}
			
			
		}
		
		for(int i = 0; i<N; i++) {
			if(allSongSet.equals(heardSongList.get(i)))
				System.out.println(i+1);
		}
	}
}
