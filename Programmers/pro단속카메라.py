def solution(routes):
    answer = 0
    routes.sort(key = lambda x:x[1])
    check = [0] * len(routes)
    for i, route in enumerate(routes):
        if check[i] == 0: 
            check[i] = 1
            answer += 1
            for j, r in enumerate(routes):
                if r[0] <= route[1] <= r[1] and check[j] == 0:
                    check[j] = 1
    return answer