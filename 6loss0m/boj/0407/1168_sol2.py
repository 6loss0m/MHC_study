N, K = map(int, input().split())

circular_queue = [i for i in range(1, N+1)]
cursor = 0
result = []
for _ in range(N):
    cursor += K-1
    cursor %= len(circular_queue)
    result.append(str(circular_queue.pop(cursor)))

print("<"+", ".join(result)+">")