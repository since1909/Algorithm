def solution(skill, skill_trees):
    answer = 0
    skill_list = [] 
    for item in skill_trees:
        tmpstr = ""
        for i in range(len(item)):
            if item[i] in skill:
                tmpstr += item[i]
        skill_list.append(tmpstr)
    for item in skill_list:
        correct = True
        for i in range(len(item)):
            if item[i] != skill[i]: 
                correct = False
                break
        if correct : answer += 1
        
    return answer