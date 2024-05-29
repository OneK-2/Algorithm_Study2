# 유레카 이론
t = int(input())

for testcase in range(t):
    num = int(input())
    arr = [1]
    
    for i in range(1, 45):
        arr.append(arr[i-1]+i+1)
    ans = 0
    # print(arr)
    
    for one in arr:
        for two in arr:
            for three in arr:
                if one + two + three == num :
                    ans = 1
    print(ans)
                    
