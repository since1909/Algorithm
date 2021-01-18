def J(n, u):
    if u == 0:
        return int(1 * 65536)
    return int(n/u * 65536)

def solution(str1, str2):
    answer = 0
    a = []
    for i in range(0, len(str1)-1):
        if str1[i:i+2].isalpha() : a.append(str1[i:i+2].lower())
    b = []
    for i in range(0, len(str2)-1):
        if str2[i:i+2].isalpha() : b.append(str2[i:i+2].lower())
    inter = 0
    union = 0
    for item in list(set(a) & set(b)):
        inter += a.count(item) if a.count(item) < b.count(item) else b.count(item)
    union = len(a) + len(b) - inter
    answer = J(inter, union)
    return answer