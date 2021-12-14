# 문제가 개편되었습니다. 이로 인해 함수 구성이나 테스트케이스가 변경되어, 과거의 코드는 동작하지 않을 수 있습니다.
# 새로운 함수 구성을 적용하려면 [코드 초기화] 버튼을 누르세요. 단, [코드 초기화] 버튼을 누르면 작성 중인 코드는 사라집니다.
'''
def solution(name):
    answer = 0
    n = len(name)

    def alphabet_to_num(char):
        num_char = [i for i in range(14)] + [j for j in range(12, 0, -1)]
        return num_char[ord(char) - ord('A')]

    for ch in name:
        answer += alphabet_to_num(ch)

    move = n - 1
    for idx in range(n):
        next_idx = idx + 1
        while (next_idx < n) and (name[next_idx] == 'A'):
            next_idx += 1
        distance = min(idx, n - next_idx)
        move = min(move, idx + n - next_idx + distance)

    answer += move
    return answer

'''
def solution(name):
    answer = 0
    min_move = len(name) - 1
    next = 0
    
    # J E R O E N
    for i, char in enumerate(name):
        # ord : 문자의 유니코드 반환
        # 앞,뒤 어느 방향이 더 적게 움직이는지 판단
        answer += min(ord(char) - ord('A'), ord('Z') - ord(char) + 1)
        
        #한칸 이동
        next = i + 1
        #만들고자 하는 이름이 완성되지 않았고, 해당 알파벳이 'A'인 경우
        while next < len(name) and name[next] == 'A':
            next += 1
        # i + i : 현재까지 움직인 횟수 + 되돌아가야 하는 횟수
        # len(name) - next : 앞으로 남은 최소 횟수
        min_move = min(min_move, i + i + len(name) - next)
    answer += min_move
    return answer
# BBAA
# BAAAAAAAAAAAAAM