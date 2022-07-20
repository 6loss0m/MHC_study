# 12981 - 영어 끝말잇기
# 끝나는 마지막 알파벳으로 끝말잇기를 이어나가야 한다.
# 마지막 사람 이후 다시 첫번째 사람으로 돌아온다.
# 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 해야한다.

def solution(n, words):
    answer = [] # 정답 (가장 먼저 탈락하는 사람 번호, 그 사람이 자신의 몇번째 차레에 탈락하는지)
    used = [words[0]] # 첫번째 단어를 먼저 사용한 used 리스트에 넣기
    finish = 0 #
    for i in range(1, len(words)): # 먼저 사용한 words[0]을 제외하고 1부터 단어의 길이까지 반복문

        if words[i][0] != used[-1][-1]: # 마지막으로 사용한 단어의 마지막 알파벳과 words의 첫번째 알파벳이 동일하지 않다면
            # 끝말잇기 오답
            finish = i # 게임이 끝났음, 현재 몇번째 돌았는지 확인해야하므로 i값을 대입
            break
        elif words[i] in used: # 나왔던 단어 사용한 경우에도 오답처리
            finish = i # 게임이 끝났음, 현재 몇번째 돌았는지 확인해야하므로 i값을 대입
            break
        else: # 끝말잇기 정답, used에 사용한 단어를 추가하여 반복문을 이어나간다.
            used.append(words[i])

    if finish == 0 : # 탈락자가 생기지 않은 경우 answer 값은 [0,0]이다.
        answer = [0,0]
    else: # 탈락자가 생긴 경우 answer 값은
        answer = [(finish % n + 1), (finish // n + 1)]
        # 몇명의 사람이 지나갔는지 알수있는 finish를 사람 인원수로 나눈 나머지에 +1하면 가장 먼저 탈락하는 사람의 번호가 나타나고
        # finish를 사람인원수로 나눈 몫에 +1하면 자신이 몇 번째 차레에 탈락했는지 구할 수 있다.

    return answer