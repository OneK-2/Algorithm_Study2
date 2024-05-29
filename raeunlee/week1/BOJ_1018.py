n, m = map(int, input().split())
board = [input() for _ in range(n)]

min_changes = float('inf')

# 시작 색깔을 바꿔가며 탐색
for start_color in ['W', 'B']:
    for i in range(n-7):
        for j in range(m-7):
            changes = 0
            for x in range(8):
                for y in range(8):
                    if (x + y) % 2 == 0:  # 짝수자리 - 시작 자리랑 같아야 함
                        if board[i+x][j+y] != start_color: # 시작자리랑 다르면 +1
                            changes += 1
                    else:  # 홀수자리 - 다른 색 이어야 함
                        if board[i+x][j+y] == start_color: # 시작자리랑 같으면 +1
                            changes += 1
            min_changes = min(min_changes, changes)

print(min_changes)
