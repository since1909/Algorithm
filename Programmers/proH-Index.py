def solution(citations):
    answer = 0
    citations.sort(reverse = True)
    for i, c in enumerate(citations):
        if c > i:
            if citations.count(c) > 1 : 
                answer = i + citations.count(c)
                if answer > c: break
            else:
                answer = i+1
                if answer > c: break
    return answer