def solution(s):
    stack = []
    if s.count("(") != s.count(")"): return False
    for p in s:
        if p == "(": stack.append(p)
        else:
            if stack: stack.pop()
    return not stack