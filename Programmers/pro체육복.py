def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    eraselist = []
    for l in lost:
        if l in reserve:
                reserve.remove(l)
                eraselist.append(l)
    for e in eraselist:
        lost.remove(e)
    answer = n - len(lost)
    eraselist = []
    for l in lost:
        if l-1 in reserve:
            reserve.remove(l-1)
            answer += 1
            continue
        if l+1 in reserve:
            reserve.remove(l+1)
            answer += 1
            continue
    return answer