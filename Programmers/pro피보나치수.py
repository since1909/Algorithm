def solution(n):
    data = [0] * (n+1)
    for i in range(n+1):
        if i == 0: data[i] = 0
        if i == 1: data[i] = 1
        else:
            data[i] = data[i-1] + data[i-2]
    return data[n] % 1234567