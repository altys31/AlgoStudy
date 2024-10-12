class Solution {
    public int solution(String dirs) {
        int answer = 0;
        //위 = 0 ,오른 == 1, 아래 == 2, 왼쪽 = 3,   
        boolean[][][] visited = new boolean[11][11][4];

        int x = 5;
        int y = 5;
        int nx;
        int ny;
        for(char dir : dirs.toCharArray()){
            switch(dir){
                case 'U':
                    ny = y-1;
                    if(ny < 0)
                        continue;
                    if(!visited[y][x][0])
                        answer++;
                    visited[y][x][0] = true;
                    visited[ny][x][2] = true;
                    y = ny;
                    break;
                case 'R':
                    nx = x+1;
                    if(nx > 10)
                        continue;
                    if(!visited[y][x][1])
                        answer++;
                    visited[y][x][1] =true;
                    visited[y][nx][3] =true;
                    x = nx;
                    break;
                case 'D':
                    ny = y+1;
                    if(ny > 10)
                        continue;
                    if(!visited[y][x][2])
                        answer++;
                    visited[y][x][2] = true;
                    visited[ny][x][0] =true;
                    y = ny;
                    break;
                case 'L':
                    nx = x-1;
                    if(nx < 0)
                        continue;
                    if(!visited[y][x][3])
                        answer++;
                    visited[y][x][3] = true;
                    visited[y][nx][1] = true;
                    x = nx;
                    break;
            }
        }



        return answer;
    }
}