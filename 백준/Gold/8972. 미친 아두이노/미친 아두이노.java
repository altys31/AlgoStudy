import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	static class Robot{
		int y;
		int x;
		boolean isConflit;

		
		public Robot(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Robot other = (Robot) obj;
			return x == other.x && y == other.y;
		}
		
	}
	static int[] dx = {-1,0,1,-1,0,1,-1,0,1};
	static int[] dy = {1,1,1,0,0,0,-1,-1,-1};
	static int[] js;
	static boolean dead;
	static int deadCount = 0;
	static int R;
	static int C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		ArrayList<Robot> robots = new ArrayList<Robot>();
		Queue<Integer> moves = new ArrayDeque<Integer>();
		js = new int [2];
		dead = false;
		
		
		for(int i =0; i<R; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0 ; j<C; j++) {
				
				if(line[j] == 'R') 
					robots.add(new Robot(i,j));
				
				else if (line[j] == 'I') {
					js[0] = i;
					js[1] = j;
				}
			}
		}
		
		String line = br.readLine();
		for(int i =0; i<line.length(); i++)
			moves.add(Integer.parseInt(line.charAt(i)+""));

		game(moves,robots);
		
		if(dead)
			System.out.println("kraj "+deadCount);
		else {
			Robot[][] robotArray = new Robot[R][C];
			for(int i=0; i<robots.size(); i++) {
				Robot robot = robots.get(i);
				robotArray[robot.y][robot.x] = robot;
			}
			
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C; j++) {
					if(robotArray[i][j] != null)
						bw.append("R");
					else if(js[0] == i && js[1] == j)
						bw.append("I");
					else
						bw.append(".");
				}
				bw.append("\n");
			}
			
		}
		bw.close();
		
	}
	
	static void game(Queue<Integer> moves, ArrayList<Robot> robots) {
		while(!moves.isEmpty() && !dead) {
			deadCount++;
			jsmove(moves,robots);
			if(dead)
				return;
			robotsMove(moves,robots);
		}
		
	}
	
	static void jsmove(Queue<Integer> moves, ArrayList<Robot> robots) {
		int dir = moves.poll();
		js[0] += dy[dir-1];
		js[1] += dx[dir-1];
		
		for(int i = 0; i<robots.size(); i++) {
			Robot robot = robots.get(i);
			if(robot.y == js[0] && robot.x == js[1]){
				dead = true;
				return;
			}
		}
		
	}
	
	static void robotsMove(Queue<Integer> moves, ArrayList<Robot> robots) {
		Robot[][] robotArray = new Robot[R][C];
		Robot robot;
		
		for(int i =0; i<robots.size(); i++) {
			
			robot = robots.get(i);
			
			if(js[0] == robot.y && js[1] != robot.x){
				if(js[1] > robot.x) 
					robot.x++;
				else
					robot.x--;
			}
			else if(js[0] != robot.y && js[1] == robot.x) {
				if(js[0]> robot.y)
					robot.y++;
				else
					robot.y--;
			}
			else if(js[0] > robot.y && js[1] > robot.x) {
				robot.y += dy[2];
				robot.x += dx[2];
			}
			else if(js[0] > robot.y && js[1] < robot.x) {
				robot.y += dy[0];
				robot.x += dx[0];
			}
			else if(js[0] < robot.y && js[1] > robot.x) {
				robot.y += dy[8];
				robot.x += dx[8];
			}
			else if(js[0] < robot.y && js[1] <robot.x) {
				robot.y += dy[6];
				robot.x += dx[6];
			}
			
			if(js[0]== robot.y && js[1]==robot.x) {
				dead = true;
				return;
			}
			
			if(robotArray[robot.y][robot.x] == null)
				robotArray[robot.y][robot.x] = robot;
			else
				robotArray[robot.y][robot.x].isConflit = true;
			
		}
		
		robots.clear();
		
		for(int i = 0; i<R; i++) {
			for(int j =0; j<C; j++) {
				if(robotArray[i][j]!=null && !robotArray[i][j].isConflit) {
					robots.add(robotArray[i][j]);
				}
			}
		}
			
	}

}