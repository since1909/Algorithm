import heapq
def solution(N, road, K):
    answer = 0
    nodes = {}
    for v1, v2, d in road:
        nodes[v1] = nodes.get(v1, []) + [(v2, d)]
        nodes[v2] = nodes.get(v2, []) + [(v1, d)]
    dist = { i:float('inf') if i != 1 else 0 for i in range(1, N+1) }
    q = []
    heapq.heappush(q, [dist[1], 1])
    while q:
        weight, node = heapq.heappop(q)
        if dist[node] < weight: continue
        for n, w in nodes[node]:
            d = weight + w
            if d < dist[n]: 
                dist[n] = d
                heapq.heappush(q, [d, n])
    return len([1 for dist in dist.values() if dist <= K])