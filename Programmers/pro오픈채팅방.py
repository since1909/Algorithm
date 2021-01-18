def solution(record):
    result = {}
    answer = []
    for item in record:
        log = item.split()
        if log[0] == "Change":
            result[log[1]] = log[2]
        elif log[0] == "Leave":
            answer.append([log[1], "님이 나갔습니다."])
        else:
            result[log[1]] = log[2]
            answer.append([log[1], "님이 들어왔습니다."])
    return ["{}{}".format(result[a[0]], a[1]) for a in answer]