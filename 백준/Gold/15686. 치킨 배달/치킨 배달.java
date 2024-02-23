import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static int[][] arr;
	private static boolean[] visited;
	private static int answer = Integer.MAX_VALUE;
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static ArrayList<Point> home_list = new ArrayList();
	private static ArrayList<Point> chicken = new ArrayList();
	private static ArrayList<Point> chickenList = new ArrayList();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 1) {
					home_list.add(new Point(i, j));
				} else if (arr[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}

		visited = new boolean[chicken.size()];

		dfs(0, 0);

		System.out.println(answer);

	}// main

	private static void dfs(int start, int count) {

		if (count == M) {

			int sum = 0;
			for (int i = 0; i < home_list.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < chickenList.size(); j++) {
					int distance = Math.abs(home_list.get(i).x - chickenList.get(j).x)
							+ Math.abs(home_list.get(i).y - chickenList.get(j).y);

					if (min > distance) {
						min = distance;
					}
				}
				sum += min;
			}

			if (sum < answer) {
				answer = sum;
			}

		} else {

			for (int i = start; i < chicken.size(); i++) {
				if (!visited[i]) {
					visited[i] = true;
					chickenList.add(chicken.get(i));
					dfs(i + 1, count + 1);
					chickenList.remove(chickenList.size() - 1);
					visited[i] = false;
				}
			}

		}

	}

	
}