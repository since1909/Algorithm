def solution(n, t, m, timetable):
    answer = ''
    timetable.sort()
    h = 0
    M = 0
    bus_start = 9*60
    timeInt = []
    for time in timetable:
        h, M = time.split(":")
        timeInt.append(int(h) * 60 + int(M))
    bus_time = [int(bus_start + i * t) for i in range(n)]
    
    conMax = 0
    for time in bus_time:
        num = sum(1 for item in timeInt if item <= time)
        if num < m:
            timeInt = timeInt[num:]
            if conMax < time: conMax = time
        else:
            if conMax < timeInt[m-1] -1: conMax = timeInt[m-1] -1
            timeInt = timeInt[m:]
            
    hour = str(int(conMax / 60)).rjust(2,'0')
    min = str(int(conMax % 60)).rjust(2, '0')
    answer = hour + ":"+ min
    return answer