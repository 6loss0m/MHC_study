def solution(answers):
    a1 = [1,2,3,4,5]
    a2 = [2,1,2,3,2,4,2,5]
    a3 = [3,3,1,1,2,2,4,4,5,5]
    m_list = [0,0,0]
    answer = []

    for i in range(len(answers)):
        if answers[i] == a1[i%5]:
                   m_list[0] = m_list[0]+1
        if answers[i] == a2[i%8]:
                   m_list[1] = m_list[1]+1
        if answers[i] == a3[i%10]:
                   m_list[2] = m_list[2]+1
    m = max(m_list)
    if m == m_list[0]:
        answer.append(1)
    if m == m_list[1]:
        answer.append(2)
    if m == m_list[2]:
        answer.append(3)
    
    return answer