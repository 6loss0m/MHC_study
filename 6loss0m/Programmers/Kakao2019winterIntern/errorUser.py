from itertools import permutations 
import re 

def solution(user_id, banned_id):
    answer = set()
    n = len(banned_id)
    # 제재 아이디 개수 
    perm = list(permutations(user_id, n))
    # user_id의 n개 원소로 순열 생성
    for p in perm:
        cnt = 0 
        # 아이디가 일치하는지 확인 
        for i in range(n):
            if not re.match(banned_id[i].replace('*', '.'), p[i]) or len(banned_id[i]) != len(p[i]): 
                break 
            else:
                cnt += 1 
                # p로 제재 아이디 목록은 만들 수 있음
                if cnt == n: 
                    answer.add(frozenset(p)) 
    
    return len(answer)