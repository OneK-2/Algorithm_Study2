n , s = map(int, input().split())
l = list(map(int, input().split()))
ans = 0
tmp = []

def backtracking(start):
    global ans
    if sum(tmp) == s and len(tmp) > 0:
        ans += 1
    
    for i in range(start, n):
        tmp.append(l[i])
        backtracking(i+1)
        tmp.pop()

backtracking(0)
print(ans)


# from itertools import combinations


# n , s = map(int, input().split())
# l = list(map(int, input().split()))
# ans = 0

# for i in range(1, n+1):
#     comb = combinations(l, i)

#     for c in comb:
#         if sum(c) == s:
#             ans += 1
# print(ans)