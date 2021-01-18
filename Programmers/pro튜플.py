def solution(s):
    answer = []
    s = s[1:-1].split("}")
    s[0] = "," + s[0]
    for i, ss in enumerate(s):
        if i == len(s)-1: break
        s[i] = list(map(int, ss[2:].split(",")))
    s = s[:-1]  
    s.sort(key = lambda x: len(x))
    for ss in s:
        for sss in ss:
            if sss not in answer: answer.append(sss)
    return answer