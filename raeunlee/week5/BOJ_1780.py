# 종이의 개수

n = int(input())

arr =[]

for _ in range(n):
    tmp = list(map(int, input().split()))
    arr.append(tmp)

minus_cnt, zero_cnt, plus_cnt = 0, 0, 0

def check(row, col, n):
    global minus_cnt, zero_cnt, plus_cnt
    curr = arr[row][col]
    # 처음부터 끝까지 검사
    for i in range(row, row + n):
        for j in range(col, col + n):
            # 첫번째 종이랑 숫자가 다른게 있다면?
            if arr[i][j] != curr:
                # 9개의 작은 배열로 나누어서 검사한다
                for x in range(3):
                    for y in range(3):
                        check(row + x * n // 3, col + y * n // 3, n // 3)
                return
        
    if curr == -1:
        minus_cnt += 1

    elif curr == 0:
        zero_cnt += 1
    
    elif curr == 1:
        plus_cnt += 1    
    return
    
check(0,0,n)
print(minus_cnt)
print(zero_cnt)
print(plus_cnt)

# 종이의 개수

# n = int(input())

# arr = []

# for _ in range(n):
#     tmp = list(map(int, input().split()))
#     arr.append(tmp)

# minus_cnt, zero_cnt, plus_cnt = 0, 0, 0

# def check(row, col, size):
#     global minus_cnt, zero_cnt, plus_cnt
#     curr = arr[row][col]
#     all_same = True
    
#     for i in range(row, row + size):
#         for j in range(col, col + size):
#             if arr[i][j] != curr:
#                 all_same = False
#                 break
#         if not all_same:
#             break
    
#     if all_same:
#         if curr == -1:
#             minus_cnt += 1
#         elif curr == 0:
#             zero_cnt += 1
#         elif curr == 1:
#             plus_cnt += 1
#     else:
#         new_size = size // 3
#         for x in range(3):
#             for y in range(3):
#                 check(row + x * new_size, col + y * new_size, new_size)

# check(0, 0, n)
# print(minus_cnt)
# print(zero_cnt)
# print(plus_cnt)
