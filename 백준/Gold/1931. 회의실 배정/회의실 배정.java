import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    ArrayList<int[]> list = new ArrayList<int[]>();
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
    }
    list.sort(new Comparator<int[]>() {
      public int compare(int[] o1, int[] o2) {
        if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
        return Integer.compare(o1[1], o2[1]);
      }
    });

    int count = 0;
		int prev_end_time = 0;
		
        for (int i = 0; i < N; i++) {

          if (prev_end_time <= list.get(i)[0]) {
            prev_end_time = list.get(i)[1];
            count++;
          }
        }
    
        System.out.println(count);

  }
}

