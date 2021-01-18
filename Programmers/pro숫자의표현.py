def solution(n):
    answer = 0
    for i in range(1, n+1):
        result = 0
        num = i
        while result < n:
            result +=  num
            num += 1
        if result == n: answer += 1
    return answer