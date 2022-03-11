#(i) 0 1 2 3 4 (j)
# 0 [0,0,0,0,0]
# 1 [0,0,1,0,3]
# 2 [0,2,5,0,1]
# 3 [4,2,4,4,2]
# 4 [3,5,1,3,1]
# move
# [1,5,3,5,1,2,1,4]
def solution(board, moves):
    answer = 0
    basket = []  
    # board : 0 ~ 5
    for i in moves:
        j = 0
        if board[len(board)-1][i-1] == 0:
            continue
        while board[j][i-1] == 0 and j < len(board):
            j = j + 1
        # basket이 비어있지 않고
        # 제일 위에 있는게 같은경우
        if len(basket) == 0 :
            basket.append(board[j][i-1])
        elif basket[-1] == board[j][i-1] :
            basket.pop()
            answer = answer + 2
        else :
            basket.append(board[j][i-1])
        board[j][i-1] = 0
    return answer