import sys
input = sys.stdin.readline
n = int(input())
l = list(map(int, input().split()))

dp = [[False] * n for _ in range(n)]

# 한자리는 무조건 펠린드롬
for i in range(n):
    dp[i][i] = True

# 두자리는 두개가 같으면 펠린드롬
for i in range(n-1):
    if l[i] == l[i+1]:
        dp[i][i+1] = True

# 세자리 이상은 양 끝이 같고, 그 내부가 펠린들롬이어야 함
for length in range(3, n+1):
    for i in range(n-length+1):
        j = i + length - 1
        if l[i] == l[j] and dp[i+1][j-1]:
            dp[i][j] = True

m = int(input())
for _ in range(m):
    a, b = map(int, input().split())
    if dp[a-1][b-1]:
        print(1)
    else:
        print(0)

# n = int(input())
# l = list(map(int, input().split()))

# m = int(input())
# for i in range(m):
#     a, b = map(int, input().split())
#     # 팰린들롬의 길이
#     tmp = []

#     for j in range(a,b+1):
#         tmp.append(l[j-1])
#     tmp2 = list(reversed(tmp))
#     # print(tmp, tmp2)

#     flag = True
#     for k in range(len(tmp)):
#         if tmp[k] != tmp2[k]:
#             flag = False
#     if flag == True:
#         print(1)
#     else:
#         print(0)