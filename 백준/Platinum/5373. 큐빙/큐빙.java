

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Character[]> spin_q = new ArrayDeque<>();
		Queue<Character> color_q = new ArrayDeque<>();
		
		int n = Integer.parseInt(st.nextToken());
		
		char[] up = new char[9];		//위
		char[] down = new char[9];		//아래
		char[] left = new char[9];		//왼쪽
		char[] right = new char[9];	//오른쪽
		char[] front = new char[9];	//앞쪽
		char[] back = new char[9];		//뒷쪽

		int[][] F = {{6,7,8},{6,3,0},{0,1,2},{8,5,2}}; //위-오른-아랫-왼쪽
		int[][] B = {{0,1,2},{0,3,6},{6,7,8},{2,5,8}}; //위-왼-아래-오른
		int[][] R = {{2,5,8},{2,5,8},{0,3,6},{2,5,8}}; //앞-위-뒤-아래
		int[][] L = {{0,3,6},{0,3,6},{2,5,8},{0,3,6}}; //앞-아래-뒤-위
		int[][] U = {{0,1,2},{0,1,2},{0,1,2},{0,1,2}}; //왼-뒤-오른-앞
		int[][] D = {{6,7,8},{6,7,8},{6,7,8},{6,7,8}}; //오른-뒤-왼-앞

		for(int t = 0; t<n; t++) {
			Arrays.fill(up, 'w');
			Arrays.fill(down, 'y');
			Arrays.fill(left, 'g');
			Arrays.fill(right, 'b');
			Arrays.fill(front, 'r');
			Arrays.fill(back, 'o');
			int time = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<time; i++) {
				char[] s = st.nextToken().toCharArray();
				spin_q.add(new Character[] {s[0],s[1]});
			}
			
			while(!spin_q.isEmpty()) {
				Character[] spin = spin_q.poll();
				char layer = spin[0];
				boolean direction = false;
				if(spin[1] == '+')
					direction = true;
				switch(layer) {
					case 'U': 	//윗면 회전
						up = layer_spin(up,direction);
						//왼-뒤-오른-앞
						for(int a : U[0]) 
							color_q.add(left[a]);
						for(int a : U[1]) 
							color_q.add(back[a]);
						for(int a : U[2]) 
							color_q.add(right[a]);
						for(int a : U[3]) 
							color_q.add(front[a]);
						
						if(direction) {
							for(int a : U[1]) 
								back[a] = color_q.poll();
							for(int a : U[2]) 
								right[a] = color_q.poll();
							for(int a : U[3]) 
								front[a] = color_q.poll();
							for(int a : U[0]) 
								left[a] = color_q.poll();
						}
						else {
							//오른-뒤-왼-앞 (반시계)
							for(int a : U[3]) 
								front[a] = color_q.poll();
							for(int a : U[0]) 
								left[a] = color_q.poll();
							for(int a : U[1]) 
								back[a] = color_q.poll();
							for(int a : U[2]) 
								right[a] = color_q.poll();
						}
						
						
						break;
					case 'D': 	//아랫면 회전
						down = layer_spin(down,direction);
						//오른-뒤-왼-앞(시계)
						for(int a : D[0]) 
							color_q.add(right[a]);
						for(int a : D[1]) 
							color_q.add(back[a]);
						for(int a : D[2]) 
							color_q.add(left[a]);
						for(int a : D[3]) 
							color_q.add(front[a]);
						if(direction) {

							for(int a : D[1]) 
								back[a] = color_q.poll();
							for(int a : D[2]) 
								left[a] = color_q.poll();
							for(int a : D[3]) 
								front[a] = color_q.poll();
							for(int a : D[0]) 
								right[a] = color_q.poll();
						}
						else {
							//왼-뒤-오른-앞(반시계
							for(int a : D[3]) 
								front[a] = color_q.poll();
							for(int a : D[0]) 
								right[a] = color_q.poll();
							for(int a : D[1]) 
								back[a] = color_q.poll();
							for(int a : D[2]) 
								left[a] = color_q.poll();
						}
						break;
					case 'F': 	//앞면 회전
						front = layer_spin(front,direction);
						//위-오른-아랫-왼쪽
						for(int a : F[0]) 
							color_q.add(up[a]);
						for(int a : F[1]) 
							color_q.add(right[a]);
						for(int a : F[2]) 
							color_q.add(down[a]);
						for(int a : F[3]) 
							color_q.add(left[a]);	
						
						//위-오른-아래-왼쪽(시계)
						if(direction) {
							for(int a = 2; a >= 0; a--) 
								right[F[1][a]] = color_q.poll();
							for(int a : F[2]) 
								down[a] = color_q.poll();
							for(int a = 2; a >= 0; a--) 
								left[F[3][a]] = color_q.poll();
							for(int a : F[0]) 
								up[a] = color_q.poll();
						}
						else {
							//아래-왼쪽-위-오른(반시계)
							for(int a : F[3]) 
								left[a] = color_q.poll();
							for(int a = 2; a >= 0; a--) 
								up[F[0][a]] = color_q.poll();
							for(int a : F[1]) 
								right[a] = color_q.poll();
							for(int a = 2; a >= 0; a--) 
								down[F[2][a]] = color_q.poll();



							
						}
						
						
						break;
					case 'B':	//뒷면 회전
						back = layer_spin(back,direction);
						//위-왼-아래-오른
						for(int a : B[0]) 
							color_q.add(up[a]);
						for(int a : B[1]) 
							color_q.add(left[a]);
						for(int a : B[2]) 
							color_q.add(down[a]);
						for(int a : B[3]) 
							color_q.add(right[a]);
						

						//회전
						if(direction){
							for(int a = 2; a >= 0; a--) 
								left[B[1][a]] = color_q.poll();
							for(int a : B[2]) 
								down[a] = color_q.poll();
							for(int a = 2; a >= 0; a--) 
								right[B[3][a]] = color_q.poll();
							for(int a : B[0]) 
								up[a] = color_q.poll();
						}
						else {
							//위-왼-아래-오른
							//오른-아래-왼-위
							for(int a : B[3]) 
								right[a] = color_q.poll();
							for(int a = 2; a >= 0; a--) 
								up[B[0][a]] = color_q.poll();
							for(int a : B[1]) 
								left[a] = color_q.poll();
							for(int a = 2; a >= 0; a--) 
								down[B[2][a]] = color_q.poll();

							
							
						}
						
						
						break;
					case 'L':	//왼쪽면
						left = layer_spin(left,direction);
						//앞-아래-뒤-위
						for (int a : L[0])
							color_q.add(front[a]);
						for (int a : L[1])
							color_q.add(down[a]);
						for(int a = 2; a >= 0; a--) 
							color_q.add(back[L[2][a]]);
						for (int a : L[3])
							color_q.add(up[a]);
							
						if(direction) {
							for (int a : L[1])
								down[a] = color_q.poll();
							for(int a = 2; a >= 0; a--) 
								back[L[2][a]] = color_q.poll();
							for (int a : L[3])
								up[a] = color_q.poll();
							for (int a : L[0])
								front[a] = color_q.poll();
						}
						else {
							for(int a : L[3])
								up[a] = color_q.poll();
							for(int a : L[0])
								front[a] = color_q.poll();
							for(int a : L[1])
								down[a] = color_q.poll();
							for(int a = 2; a >= 0; a--) 
								back[L[2][a]] = color_q.poll();
							}
						break;
						
					case 'R':
						right = layer_spin(right,direction);
						//앞-위-뒤-아래
						for(int a : R[0]) 
							color_q.add(front[a]);
						for(int a : R[1]) 
							color_q.add(up[a]);
						for(int a = 2; a >= 0; a--) 
							color_q.add(back[R[2][a]]);
						for(int a : R[3]) 
							color_q.add(down[a]);

						//앞-위-뒤-아래
						if(direction) {
							for(int a: R[1])
								up[a] = color_q.poll();
							for(int a = 2; a >= 0; a--) 
								back[R[2][a]] = color_q.poll();
							for(int a: R[3])
								down[a] = color_q.poll();
							for(int a: R[0])
								front[a] = color_q.poll();
						}
						else {
							for(int a: R[3])
								down[a] = color_q.poll();
							for(int a: R[0])
								front[a] = color_q.poll();
							for(int a: R[1])
								up[a] = color_q.poll();
							for(int a = 2; a >= 0; a--) 
								back[R[2][a]] = color_q.poll();
				
						}
						break;
				}
				
			}
			for(int i = 0 ; i<9; i++) {
				bw.append(up[i]);
				if(i%3==2)
					bw.append("\n");
			}				
		}
		bw.close();
		
	}
	
	//회전시키는 면의 배열을 회전 
	static char[] layer_spin(char[] color,boolean direction) {
		char[][] arr = new char[3][3];
		char[][] rotated_arr = new char[3][3];
		
		for(int i = 0; i<9; i++) 
			arr[i/3][i%3] = color[i];
		
		if(direction) {
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<3; j++) {
					rotated_arr[j][2-i] = arr[i][j];
				}
			}

			
		}
		else {
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<3; j++) {
					rotated_arr[2-j][i] = arr[i][j];
				}
			}
			
		}
		for(int i = 0; i<9;i++) {
			color[i] = rotated_arr[i/3][i%3];
		}
		return color;
			
		
	}

}