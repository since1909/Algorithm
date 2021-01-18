from collections import deque
def solution(n, edge):
    answer = 0
    graph = {}
    for item in edge:
        graph[item[0]] = graph.get(item[0], []) + [item[1]]
        graph[item[1]] = graph.get(item[1], []) + [item[0]]
    
    q = deque([[1, 0]])
    v = [-1] * (n+1)
    while q:
        node, depth = q.popleft()
        v[node] = depth
        for n in graph[node]:
            if v[n] == -1:
                v[n] = 0
                q.append([n, depth + 1])
    return v.count(max(v))