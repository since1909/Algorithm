def solution(dartResult):
    answer = 0
    def point(x):
        return {'S' : '1', 'D' : '2', 'T' : '3'}[x]
    def option(x):
        return {'*' : "*2", '#' : "*(-1)"}[x]

    exp = []
    for i in range(len(dartResult)):
        if dartResult[i].isalpha():
            if (i-1) != 0 and dartResult[i-2] == "1": 
                exp.append(str(pow(10, int(point(dartResult[i])))))
            else:
                exp.append(str(pow(int(dartResult[i-1]), int(point(dartResult[i])))))
        elif not dartResult[i].isdigit() and not dartResult[i].isalpha():
            if dartResult[i] == "*" and i != 2:
                exp[-2] = exp[-2] + option(dartResult[i])
            exp[-1] = exp[-1] + option(dartResult[i])
    #for item in exp:
        #answer += eval(item)
    return sum(eval(item) for item in exp)