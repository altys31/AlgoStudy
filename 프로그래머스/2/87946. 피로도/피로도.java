class Solution {
    static int n;
    static int answer; 
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        n = dungeons.length;
        boolean[] visited = new boolean[n];
        bt(visited, dungeons, k, 0);
        
        return answer;
    }
    
    public void bt(boolean[] visited, int[][] dungeons, int remains, int level){
        if(level >= answer && level != 0)
            answer = level; 

        for(int i = 0; i<n; i++){
            if(visited[i])
                continue;
            if(remains >= dungeons[i][0]){
                visited[i] = true;
                bt(visited, dungeons, remains - dungeons[i][1], level+1);
                visited[i] = false; 
            }
            
        }
        
    }
}