import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
    static int answer;
    static int N;
    static int M;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Boolean[][] table = new Boolean[N+1][N+1];
             
            for(int i = 0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
             
                table[a][b] = false;
                table[b][a] = true;
                 
            }
             
            for(int i = 1; i< N+1; i++) 
                dfs(i, new boolean[N+1],table);
            System.out.println(answer);
    }
     
    static void dfs(int num , boolean[] check,Boolean[][] table) {
        int count = 1;
        check[num] = true;
        for(int i = 1; i<N+1; i++) {
            if(i== num)
                continue;
            if(table[num][i] != null && !check[i]) {
                count++;
                check[i] = true;
                count += link(table,check,table[num][i], i);
            }
        }
         
        if(count == N)
            answer++;
 
    }
     
    static int link(Boolean[][] table,boolean[] check, boolean upOrDown, int num) {
        int count = 0;
         
        for(int i = 1; i<N+1; i++) {
            if(i==num)
                continue; 
            if(!check[i] && table[num][i] != null && table[num][i] == upOrDown) {
                check[i] = true;
                count++;
                count += link(table,check,upOrDown,i);
            }
        }
        return count;
         
    }
 
}

