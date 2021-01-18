import heapq
def solution(operations):
    answer = []
    queue = []
    for op in operations:
        operation, num = op.split()
        if operation == 'I':
            heapq.heappush(queue, int(num))
        if not queue: continue
        if operation == "D":
            if int(num) == 1:
                queue.pop()
            elif int(num) == -1:
                heapq.heappop(queue)
        queue.sort()
        #print(queue)
    if queue: answer = [queue[-1], queue[0]]
    else: answer = [0,0]
    return answer