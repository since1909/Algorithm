from itertools import chain
def solution(n):
    answer = []
    array = [[0 for _ in range(n)] for _ in range(n)]
    cnt = 1
    x, y = -1, 0
    for i in range(n):
        for j in range(i, n):
            if i % 3 == 0: x += 1
            elif i % 3 == 1: y += 1
            elif i % 3 == 2:
                x -= 1
                y -= 1
            array[x][y] = cnt
            cnt += 1
    return [i for i in chain(*array) if i != 0]