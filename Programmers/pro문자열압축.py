def solution(s):
    minlength = 1001
    sliceunit = 1
    while sliceunit < len(s)//2 + 1:
        answer = []
        i = 0
        while i < len(s):
            sub1 = s[i: i + sliceunit]
            cnt = 1
            for j in range(i + sliceunit, len(s), sliceunit):           
                if sub1 == s[j:j + sliceunit]:
                    cnt += 1
                else:
                    break
            i += sliceunit * cnt
            if cnt == 1: answer.append(sub1)
            else: answer.append(str(cnt) + sub1)
        sliceunit += 1
        ansString = "".join(answer)
        if len(ansString) < minlength: minlength = len(ansString)
    if minlength == 1001 : return len(s)
    else: return minlength