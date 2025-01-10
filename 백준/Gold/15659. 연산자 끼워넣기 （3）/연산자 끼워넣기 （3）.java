import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[] nums;
  static int[] operators = new int[4];
  static int minValue = Integer.MAX_VALUE;
  static int maxValue = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    nums = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < 4; i++) {
      operators[i] = Integer.parseInt(st.nextToken());
    }
    Deque<Integer> numQ = new LinkedList<>();
    Deque<Integer> operatorQ = new LinkedList<>();
    numQ.add(nums[0]);

    bt(0, numQ, operatorQ);
    System.out.println(maxValue);
    System.out.println(minValue);
  }
  
  static void bt(int level, Deque<Integer> numQ, Deque<Integer> operatorQ) {

    if (level == N-1) {

      while (true) {
        if (numQ.size() == 1)
          break;

        numQ.addFirst(calc(numQ.poll(), numQ.poll(), operatorQ.poll()));
      }

      int result = numQ.poll();

      maxValue = Math.max(result, maxValue);
      minValue = Math.min(result, minValue);

      return;
    }

    for (int k = 0; k < 4; k++) {

      if (operators[k] == 0) {
        continue;
      }

      operators[k]--;

      Deque<Integer> copiedNumQ = new LinkedList<>(numQ);
      Deque<Integer> copiedOperatorQ = new LinkedList<>(operatorQ);

      if (k > 1) {
          numQ.add(calc(numQ.pollLast(), nums[level+1], k));
        } else {
          numQ.add(nums[level + 1]);
          operatorQ.add(k);
        }
      
      bt(level + 1, numQ, operatorQ);

      numQ.clear();
      numQ.addAll(copiedNumQ);
      operatorQ.clear();
      operatorQ.addAll(copiedOperatorQ);
      operators[k]++;

    }

  }
  
  static int calc(int left, int right, int operator) {
    
    switch (operator) {
      case 0:
        return left + right;
      case 1:
        return left - right;
      case 2:
        return left * right;
      case 3:
        return left / right;
    }

    return 0;
}
}