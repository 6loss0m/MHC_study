# 방문 길이
def solution(dirs):
    visit = set()
    x = 0; y = 0
    for d in dirs:
        if d == 'U' and y < 5:
            visit.add(((x, y), (x, y+1)))
            y += 1

        elif d == 'D' and y > -5:
            visit.add(((x, y-1), (x, y)))
            y -= 1

        elif d == 'R' and x < 5:
            visit.add(((x, y), (x+1, y)))
            x += 1

        elif d == 'L' and x > -5:
            visit.add(((x-1, y), (x, y)))
            x -= 1
    print(visit)
    return len(visit)
dirs = "ULURRDLLU"
print(solution(dirs))