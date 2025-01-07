import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int testCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCase; i++) {
      long answer = 0;
      int N = Integer.parseInt(br.readLine());
      PriorityQueue<Long> pq = new PriorityQueue<Long>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        pq.add(Long.parseLong(st.nextToken()));
      }
      while (true) {
        if (pq.size() == 1) {
          break;
        } else {
          Long newFile = pq.poll() + pq.poll();
          answer += newFile;
          pq.add(newFile);
        }
      }
      bw.write(Long.toString(answer));
      bw.newLine();
    }
    bw.close();
  }
}
