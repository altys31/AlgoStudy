import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] visited = new int[n+1];
        ArrayList<Integer>[] relations = new ArrayList[n+1];
        
        for(int i = 2; i<n+1; i++){
                visited[i] = 999999;
        }
        
        for(int[] line : edge){
            if(relations[line[0]] == null)
                relations[line[0]] = new ArrayList<Integer> ();
                
            if(relations[line[1]] == null)
                relations[line[1]] = new ArrayList<Integer> ();

            relations[line[1]].add(line[0]);
            relations[line[0]].add(line[1]);

        }
        
        bt(1, 0, visited, relations);
        
        int maxDistance = 0;
        
        for(int i =2; i<n+1; i++){
            if(visited[i] != 999999)
                maxDistance = Math.max(visited[i],maxDistance); 
        }
        
        for(int i =2; i<n+1;i++){
            if(visited[i] == maxDistance)
                answer++;
        }
        // for(int i =1; i<n+1; i++){
        //     System.out.println(relations[i]);
        // }

        
        return answer;
    }
    
    public static void bt(int node, int level, int[] visited, ArrayList<Integer>[] relations) {
        
        for(int nextNode : relations[node]){
            if(level+1 < visited[nextNode]){
                visited[nextNode] = level+1;
                bt(nextNode, level+1, visited, relations);
            }
        }


    }
}