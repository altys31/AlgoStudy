import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //작은것끼리 먼저 비교
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int answer = 0;
    
    for (int i = 0; i < N; i++) 
      pq.add(Integer.parseInt(br.readLine()));

    while (true) {
      if (pq.size() == 1) {
        break;
      } else {
        int mergedData = pq.poll() + pq.poll();
        answer += mergedData;
        pq.add(mergedData);
      }
    }
    System.out.println(answer);
  } 
}