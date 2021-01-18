def solution(genres, plays):
    answer = []
    dic = {}
    for i in range(len(genres)):
        dic[genres[i]] = dic.get(genres[i], []) + [i]
    sortedkeys = sorted(dic.keys(), key = lambda x: sum(plays[i] for i in dic[x]), reverse = True)
    for lst in dic.values():
        lst.sort(key = lambda x : plays[x], reverse=True)
    for k in sortedkeys:
        answer.append(dic[k][0])
        if len(dic[k]) > 1:
            answer.append(dic[k][1])
    return answer