# 42891 - 무지의 먹방 라이브
# https://www.youtube.com/watch?v=zpz8SMzwiHM
#
import heapq

def solution(food_times, k):
    # 모든 음식 섭취 시간 합이 k시간과 같거나 작다면 모두 섭취한 것이기 때문에 -1
    if sum(food_times) <= k:
        return -1

    q = []
    for i in range(len(food_times)):
        heapq.heappush(q, (food_times[i], i + 1))

    sum_value = 0  # 그동안 먹었던 음식의 총 합
    previous = 0  # 바로 직전에 먹은 음식을 먹는데 소요되는 시간
    length = len(food_times)  # 남은 음식 개수

    # 지금까지 이전 음식 먹는 데 사용한 총 시간 + (이제 먹을 음식 시간 - 직전에 먹은 음식 시간) * 남은 음식 개수 -> 직전에 먹은 음식 시간을 빼주는 이유는 회전판이 돌 동안 이제 먹을 음식을 일부 먹었을 것이므로!
    while sum_value + (q[0][0] - previous) * length <= k:
        now = heapq.heappop(q)[0]  # 이제 먹을 음식 시간
        sum_value += (now - previous) * length  # 이제 먹을 음식 중 남은 시간 * 남은 음식 개수
        length -= 1
        previous = now  # 이제 먹은 음식을 이전에 먹은 음식으로 갱신

    result = sorted(q, key=lambda x: x[1])  # 음식 번호순으로 큐를 재정렬
    return result[(k - sum_value) % length][1]