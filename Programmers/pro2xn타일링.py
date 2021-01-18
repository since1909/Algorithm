def solution(n):
    answer = 0
    case1 = 1
    case2 = 1
    for i in range(n-1):
        n = (case1 + case2) % 1000000007
        case1 = case2
        case2 = n
    return case2