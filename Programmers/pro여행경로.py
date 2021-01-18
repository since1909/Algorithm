def solution(tickets):
    answer = []
    graph = dict()
    for start, end in tickets:
        graph[start] = graph.get(start, []) + [end]
    for g in graph.keys():
        graph[g].sort(reverse = True)
    
    stack = ['ICN']
    path = []
    while stack:
        print(stack)
        node = stack[-1]
        if node not in graph or len(graph[node]) == 0:
            path.append(stack.pop())
        else:
            stack.append(graph[node][-1])
            graph[node] = graph[node][:-1]
    answer = path[::-1]
    return answer