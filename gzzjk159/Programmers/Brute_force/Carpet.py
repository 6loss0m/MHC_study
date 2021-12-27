def solution(brown, yellow):    
    total = brown + yellow
    for i in range(3, int(total**0.5) + 1):
        if not total % i and (i-2) * ((total//i)-2) == yellow:
            return [total//i, i]
