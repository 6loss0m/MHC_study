# 17685 - 자동완성
# 트라이(Trie)란 문자열을 저장하고 효율적으로 탐색하기 위한 트리 형태의 자료구조
# https://maeng2world.tistory.com/214

def solution(words):
    answer = 0
    trie = {}
    for word in words: # words의 단어 하나씩
        cur_trie = trie
        for w in word: # word의 한글자씩
            cur_trie.setdefault(w, [0, {}]) # 키값과 값 하나를 인자로 받는 dict 의 매소드
            # print(cur_trie.setdefault(w, [0, {}]))
            # [0. {}]
            cur_trie[w][0] += 1
            # [1, {'o': [1, {}]}]
            # value에 해당하는 리스트는 해당 문자가 몇번 쓰였는지, 
            # 그 다음에 나오는 문자는 무엇인지 넣어줍니다,
            # 이렇게 dict를 계속 연결하고 나면, 겹치지 않는 문자의 경우 value의 0번째 값이 1이 됩니다.
            cur_trie = cur_trie[w][1]

    for word in words:
        cur_trie = trie
        for i in range(len(word)):
            w = word[i]
            if cur_trie[w][0] == 1:
                break
                #  각 문자마다 dict를 계속 확인하며 value의 0번째 값이 1이 될 때의
            cur_trie = cur_trie[w][1]
        # idx값 + 1이 답이 됩니다.
        answer += (i + 1)
    return answer