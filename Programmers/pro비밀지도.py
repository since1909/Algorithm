def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        answer.append(str(bin(arr1[i] | arr2[i]))[2:].rjust(n, "0").replace("1", "#").replace("0", " "))
    return answer