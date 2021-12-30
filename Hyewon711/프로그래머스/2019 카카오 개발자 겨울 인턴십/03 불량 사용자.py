from itertools import permutations 
#permutations : 리스트와 같은 iterable 객체에서 r개의 데이터를 뽑아 일렬로 나열하는 모든 경우를 계산

def check(users, banned_id): #아이디 검사 함수
    if len(users)!=len(banned_id): #users 길이와 필터링된 아이디(불량 사용자)의 길이가 다른 경우 
        return False # False로 함수 종료 
    else: #만약 길이가 같다면
        for i, j in zip(users,banned_id): #users와 필터링 아이디 리스트 확인
            if j == '*': # 만약 필터링된 문자열에서 *을 만나는 경우
                continue # 다음으로 넘어가기
            if i != j: #users와 banned가 다른 경우 
                return False # False로 함수 종료
        return True 
 

def solution(user_id, banned_id): #응모자 아이디, 불량 사용자
    answer=[]
    users_list = permutations(user_id,len(banned_id)) #permutations를 이용하여 순열로 나열한다.
    # 입출력 예#1 의 경우라면 
    # permutations(user_id,len(banned_id))는 아래와 같은 결과
    # [('frodo','fradi'),('frodo','crodo'),('frodo','abc123'),
    # ('frodo','frodoc'),('fradi','crodo')...('frodoc','abc123')]
    
    # user_id의 길이가 길지않으므로 순열을 이용하여 확인 
    
    for users in users_list:
        count = 0
        # users 부터 users_list(순열)까지 반복
        
        for i, j in zip(users, banned_id): 
            #길이가 같은 배열을 zip을 통해 묶기 (검사하는 users 인덱스, 불량 사용자 아이디) 
            # zip : 순회 가능한(iterable) 객체를 인자로 받고,
            # 각 객체가 담고 있는 원소를 터플의 형태로 차례로 접근할 수 있는 반복자(iterator)를 반환
            # ('frodo','fr*d*') ('frodo','abc1**') ('fradi','fr*d*') ('fradi','abc1**') ...  
            
            if check(i, j): # 아이디 검사 함수를 통해 길이가 같은지 확인
                count += 1 # count 증가 
                
        if count == len(banned_id): # count가 제재 아이디의 개수와 동일한 경우
            if set(users) not in answer: # answer에 중복되지 않은 원소가 있는 지 확인한다. 
                answer.append(set(users)) # 없는 경우 append
    return len(answer) 