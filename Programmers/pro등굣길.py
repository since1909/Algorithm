def solution(m, n, puddles):
    answer = 0
    maps = [[0 for _ in range(m+1)] for _ in range(n+1)]
    maps[1][0] = 1
    for i in range(1, n+1):
        for j in range(1, m+1):
            if [j-1,i] not in puddles: maps[i][j] = (maps[i][j] + maps[i][j-1]) % 1000000007
            if [j,i-1] not in puddles: maps[i][j] = (maps[i][j] + maps[i-1][j]) % 1000000007
    return maps[n][m]