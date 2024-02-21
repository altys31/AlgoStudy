import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int L;
	static int C;
	static char[] vowels = {'a','e','i','o','u'};
	static ArrayList<Character> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 list = new ArrayList<>();
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<C; i++) 
			list.add(st.nextToken().charAt(0));
		
		list.sort(null);
		
		comb(0,new char[L],0,bw);
		bw.close();
		
	}
	static void comb(int toselect, char[] selected, int startidx,BufferedWriter bw) throws IOException {
		if(toselect == L) {
			int vowel_num = 0;
			int consonant_num = 0;
			for(char c : selected) {
				boolean isconsonant = true;
				for(char vowel : vowels) {
					if(c == vowel) {
						vowel_num++;
						isconsonant = false;
						break;
					}
				}
				if(isconsonant)
					consonant_num++;
			}
			
			if(vowel_num > 0 && consonant_num > 1) {
				for(char c : selected) {
					bw.append(Character.toString(c));
				}
				bw.append("\n");
			}
			return;
		}
		
		for(int i =startidx; i<list.size(); i++) {
			selected[toselect] = list.get(i);
			comb(toselect+1,selected,i+1,bw);
		}
			
		
	}
}