# 숨바꼭질

from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())

q = deque()
q.append(n) # 시작점을 큐에 넣어준다
visited = [False] * (200001)
visited[n] = True # 시작점은 방문처리

# 총 3가지 경우, 현재위치 - 1, 현재위치 + 1, 현재위치 * 2 (x + x 와 같다)
cnt = 0

while q:
    for _ in range(len(q)):     
        x = q.popleft()
        if x == k:
            print(cnt)
            sys.exit(0)
        for nx in (x-1, x+1, x*2):
            if 0 <= nx <= 200000 and not visited[nx]:
                visited[nx] = True
                q.append(nx)
    cnt += 1


