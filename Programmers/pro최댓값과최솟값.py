def solution(s):
    arr = s.split(" ")
    arr.sort(key = lambda x: int(x))
    answer = str(arr[0]) + " " +str(arr[-1])
    return answer