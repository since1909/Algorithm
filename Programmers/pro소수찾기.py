from itertools import permutations

def solution(numbers):
    answer = 0
    numberlist = list(numbers)
    for i in range(2,len(numbers)+1):
        numberlist += list(permutations(list(numbers), i))
    nums = []
    for num in numberlist:
        if len(num) == 1 and num != "0":
            nums.append(num)
        else:
            tmp = ""
            for i in num: tmp += i
            if tmp[0] != '0': nums.append(tmp)
    for num in list(set(nums)):
        isPrime = True
        if int(num) != 1:
            for i in range(2, int(num)):
                if int(num) % i == 0: 
                    isPrime = False
                    break
            if isPrime: answer += 1
    print(nums)
    return answer