def solution(N, stages):
    answer = []
    fail = {}
    doing, reached, count = 0, 0, 0
    for n in range(1, N+1):
        reached = len(stages) - count
        doing = stages.count(n)
        count += doing
        if reached == 0: 
            fail[n] = 0
        else : fail[n] = doing / reached
    answer = sorted(fail, key = lambda k : fail[k], reverse = True)
    return answer