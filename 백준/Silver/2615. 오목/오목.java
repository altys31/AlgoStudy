
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int answer =0;
	
	static boolean[][] checkup;
	static boolean[][] checkdown;
	static boolean[][] checkright;
	static boolean[][] checkrightup;
	static boolean[][] checkrightdown;
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("Test5.txt"));
		//여기에 코드를 작성하세요.
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		board = new int[19][19];
		
		checkup = new boolean[19][19];
		checkdown = new boolean[19][19];
		checkright = new boolean[19][19];
		checkrightup = new boolean[19][19];
		checkrightdown = new boolean[19][19];

		
		for(int i = 0 ; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k = 0; k<19; k++) {
				board[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i<19; i++) {
			for(int j = 0; j <19; j++) {
				if (board[j][i] == 1 || board[j][i] ==2) {
					check_line(board[j][i],j,i,j,i,1,0);
				}
			}
		}
		if(answer == 0)
			System.out.println(Integer.toString(answer));
		
		
		
	}
	
	static void check_line(int stone,int j_origin, int i_origin, int j, int i, int length,int direction) throws IOException {
		
		boolean ismore = false;

		//상
		if(direction == 0 || direction == 1)
			if(j>0)
				if(board[j-1][i] == stone && !checkup[j-1][i]) {
					checkup[j-1][i] = true;
					check_line(board[j-1][i],j_origin,i_origin,j-1,i,length+1,1);
					ismore = true;
				}
		//하
		if(direction == 0 || direction == 2)

			if(j<18)
				if(board[j+1][i] == stone && !checkdown[j+1][i]) {
					checkdown[j+1][i] = true;
					check_line(board[j+1][i],j_origin,i_origin,j+1,i,length+1,2);
					ismore = true;
				}
		//우
		if(direction == 0 || direction == 3)
			if(i<18)
				if(board[j][i+1] == stone && !checkright[j][i+1]) {
					checkright[j][i+1] = true;
					check_line(board[j][i+1],j_origin,i_origin,j,i+1,length+1,3);
					ismore = true;
				}
		
		//오른쪽위
		if(direction == 0 || direction == 4)
			if(i<18 && j >0)
				if(board[j-1][i+1] == stone && !checkrightup[j-1][i+1]) {
					checkrightup[j-1][i+1] = true;
					check_line(board[j-1][i+1],j_origin,i_origin,j-1,i+1,length+1,4);
					ismore = true;
				}
		//오른쪽아래
		if(direction == 0 || direction == 5)
			if(i<18 && j <18)
				if(board[j+1][i+1] == stone && !checkrightdown[j+1][i+1]) {
					checkrightdown[j+1][i+1] = true;
					check_line(board[j+1][i+1],j_origin,i_origin,j+1,i+1,length+1,5);					
					ismore = true;
				}
		
		if(length == 5 && !ismore) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			answer = stone;
			bw.write(Integer.toString(stone));
			bw.newLine();
			bw.write(Integer.toString(j_origin+1)+" "+Integer.toString(i_origin+1));
			bw.close();
		}
		
	}
}

