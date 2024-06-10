n = int(input())
l = []

for i in range(n):
    a, b = map(int, input().split())
    l.append([a,b])

l.sort()
dis = 0

# 시작점, 끝점
start = l[0][0]
end = l[0][1]

for j in range(1, n):
    # 현재 간격이 이전 간격과 겹치는 경우
    if end >= l[j][0]:
        # 끝점을 더 큰 값으로 갱신
        end = max(end, l[j][1])
    else:
        # 겹치지 않는 경우, 현재까지의 거리를 더함
        dis += end - start
        start = l[j][0]
        end = l[j][1]

# 마지막 간격에 대한 거리 추가
dis += end - start

print(dis)