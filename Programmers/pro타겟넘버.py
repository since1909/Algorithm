def solution(numbers, target):
    answer = 0
    level = len(numbers)
    def dfs(depth, total):
        if depth == level:
            if total == target:
                nonlocal answer
                answer += 1
        else:
            dfs(depth+1, total + numbers[depth])
            dfs(depth+1, total - numbers[depth])
    dfs(0, 0)
    return answer