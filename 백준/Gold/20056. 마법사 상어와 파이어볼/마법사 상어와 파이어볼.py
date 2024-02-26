import sys
input = sys.stdin.readline
dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

def move_fireball(fireball_data):
  board = [[[] for _ in range(N)] for _ in range(N)]
  for r, c, m, s, d in fireball_data:
    if m == 0:
      continue
    nr = (r + (dr[d] * s)) % N
    nc = (c + (dc[d] * s)) % N
    board[nr][nc].append((m, s, d))
  return board

def move_end(board):
  new_board = [[[] for _ in range(N)] for _ in range(N)]
  fireball_data = []
  for r in range(N):
    for c in range(N):
      if board[r][c]:
        if len(board[r][c]) >= 2:
          m_sum = 0
          s_sum = 0
          d_check = [0, 0]
          for m, s, d in board[r][c]:
            m_sum += m
            s_sum += s
            d_check[d % 2] += 1
          if d_check[0] and d_check[1]:
            direction = [1, 3, 5, 7]
          else:
            direction = [0, 2, 4, 6]
          for d in direction:
            new_board[r][c].append((m_sum // 5, s_sum // len(board[r][c]), d))
            fireball_data.append((r, c, m_sum // 5, s_sum // len(board[r][c]), d))
        else:
          fireball_data.append((r, c, *board[r][c][0]))
  return fireball_data

N, M, K = map(int,input().split())
data = []
new_board = []
for _ in range(M):
  r, c, m, s, d = map(int,input().split())
  data.append((r-1, c-1, m, s, d))
for _ in range(K):
  board = move_fireball(data)
  data = move_end(board)
print(sum([data[i][2] for i in range(len(data))]))