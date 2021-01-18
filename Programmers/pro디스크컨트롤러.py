import heapq
def solution(jobs):
    answer, time, last = 0, 0, -1
    count, heap = 0, []
    jobs.sort()
    time = jobs[0][0]
    while count < len(jobs):
        for s, t in jobs:
            if last < s <= time:
                heapq.heappush(heap, (t, s))
        if len(heap) > 0:
            last = time
            t, s = heapq.heappop(heap)
            time += t
            answer += (time - s)
            count += 1
        else:
            time += 1
            continue
    return answer // len(jobs)