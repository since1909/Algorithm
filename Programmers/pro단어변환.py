def solution(begin, target, words):
    answer = 0
    if target not in words: return 0
    def dfs(start_node):
        level = 0
        visited = list()
        stack = list()
        stack.append(start_node)
        while stack:
            print(stack)
            node = stack.pop()
            level += 1
            if node == target:
                return level
            if node not in visited:
                visited.append(node)
                for item in words:
                    if item in stack or item in visited: continue
                    cnt = 0
                    for i in range(len(item)):
                            if node[i] != item[i]: cnt += 1
                    if cnt == 1: stack.append(item)
        #return 0
    min = len(words)+1
    for item in words:
        count = 0
        for i in range(len(item)):
            if item[i] != begin[i]: count += 1
        if count == 1:
            result = dfs(item)
            if min > result and result != 0: min = result    
    if min == len(words) + 1: min = 0
    return min