def transform(p):
    u, v = "", ""
    stack = []
    if p == "" : return ""
    leftcnt, rightcnt = 0, 0
    for s in p:
        if s == "(": leftcnt += 1
        if s == ")": rightcnt += 1
        if leftcnt == rightcnt:
            u = p[:leftcnt + rightcnt]
            v = p[leftcnt+rightcnt:]
            break
    for s in u:
        if s == "(": stack.append(s)
        else:
            if stack: stack.pop()
    if not stack: return u + transform(v)
    else:
        tmp = ""
        for i, s in enumerate(u[1:-1]):
            if s == ")": tmp += "("
            else: tmp += ")"
        return "(" + transform(v) + ")" + tmp
            
def solution(p):
    answer = ''
    stack = []
    for s in p:
        if s == "(": stack.append(s)
        else:
            if stack: stack.pop()
    if stack:
        return transform(p)
    else:
        return p
    #return answer