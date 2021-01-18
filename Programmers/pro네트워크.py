from collections import deque
def solution(n, computers):
    answer = 0
    graph = {}
    for i in range(n):
        tmp = []
        for j in range(n):
            if i == j: pass
            else:
                if computers[i][j]:
                    tmp.append(j)
        graph[i] = tmp
    def bfs(graph):
        visited = list()
        queue = deque()
        for i in range(n):
            print(i)
            if i not in visited:
                queue.append(i)
                while queue:
                    node = queue.popleft()
                    if node not in visited:
                        visited.append(node)
                        if graph[node]:
                            queue.extend(graph[node])
                        else: break
                nonlocal answer
                answer += 1
            else:
                pass
    bfs(graph)
    return answer