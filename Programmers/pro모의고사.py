def solution(answers):
    answer = []
    dic = {1: 0, 2: 0, 3: 0}
    m1 = [1,2,3,4,5]
    m2 = [2,1,2,3,2,4,2,5]
    m3 = [3,3,1,1,2,2,4,4,5,5]
    for i, ans in enumerate(answers):
        if m1[i % len(m1)] == ans: dic[1] += 1        
        if m2[i % len(m2)] == ans: dic[2] += 1
        if m3[i % len(m3)] == ans: dic[3] += 1
    maxvalue = max(dic.values())
    for k in dic.keys():
        if dic[k] == maxvalue: 
            answer.append(k)
    answer.sort()
    return answer