import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int min_answer;
	static int max_answer;
	static int[] nums;
	static int[] operator;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		operator = new int[4];

		min_answer = Integer.MAX_VALUE;
		max_answer = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		perm(1, nums[0]);
		System.out.println(max_answer);
		System.out.println(min_answer);

	}

	static void perm(int toselect, int result) {

		if (toselect == N) {
			min_answer = Math.min(result, min_answer);
			max_answer = Math.max(result, max_answer);
			return;
		}

		int num;

		num = nums[toselect];
		
		for (int j = 0; j < 4; j++) {
			if (operator[j] > 0) {
				switch (j) {
				case 0:
					operator[j]--;
					perm(toselect + 1, result + num);
					operator[j]++;
					break;
				case 1:
					operator[j]--;
					perm(toselect + 1, result - num);
					operator[j]++;
					break;
				case 2:
					operator[j]--;
					perm(toselect + 1, result * num);
					operator[j]++;
					break;
				case 3:
					operator[j]--;
					perm(toselect + 1, result/num);
					operator[j]++;
					break;
				}
			}
		}

	}

}