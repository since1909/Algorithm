def solution(array, commands):
    answer = []
    for command in commands:
        slicedarray = array[command[0]-1:command[1]]
        slicedarray.sort()
        answer.append(slicedarray[command[2]-1])
    return answer