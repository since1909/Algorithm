def solution(lines):
    time_table = []
    for line in lines:
        date, time, sss = line.split()
        H, M, S = time.split(':')
        sss = sss[:-1]
        endT = int(H)*60*60 + int(M)*60 + float(S)
        startT  = round(endT - float(sss) + 0.001,3)
        time_table.append([startT, endT])
    
    index = 0
    answer = 0
    for finish in time_table:
        index += 1
        count = 1
        for start in range(index, len(time_table)):
            if finish[1]+1 > time_table[start][0]:
                count += 1
        if answer < count:
            answer = count
    print(answer)
    return answer