# BOJ 10971 - 외판원 순회 2
# 한 도시에서 시작해서 모든 도시를 거쳐서 다시 원래의 도시로 돌아와야한다. 단, 한번 갔던 도시로는 돌아올수없다.
# W[from][to] : from -> to
city=int(input())
matrix=[[0]*city for _ in range(city)]
visit=[]
res = 0
minimum = 10000001

def combination(now, depth) :
    global res,minimum
    if depth == (city - 1) :
        #return은 연결 성분이 0일때 예외처리를 한 부분
        if matrix[0][visit[0]] == 0 :
            return
        res = matrix[0][visit[0]]
        for i in range(len(visit)-1) :
            if matrix[visit[i]][visit[i+1]] == 0 :
                return
            res = res + matrix[visit[i]][visit[i+1]]
        if matrix[visit[-1]][0] == 0 :
            return
        res = res + matrix[visit[-1]][0]

        if minimum > res :
            minimum = res

    for j in range(1,city) :
        if j not in visit :
            visit.append(j)
            combination(j,depth+1)
            visit.pop()


#2차원 배열 입력받기
for i in range(city) :
    new=input().split()
    for j in range(city) :
        matrix[i][j] = int(new[j])

#조합 순회
for i in range(1,city) :
    visit.append(i)
    combination(i,1)
    visit.pop()

print(minimum)