def solution(number, k):
    answer = [number[0]]
    numberlen = len(number) - k
    for n in number[1:]:
        while len(answer) > 0 and answer[-1] < n and 0 < k:
            answer.pop()
            k -= 1
        answer.append(n)
    return "".join(answer[:numberlen])