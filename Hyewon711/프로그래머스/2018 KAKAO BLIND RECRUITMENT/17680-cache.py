# 17680 - 캐시
# LRU 알고리즘 : 가장 오랫동안 참조되지 않은 페이지를 교체하는 방식
# 리스트의 맨 앞부분에 있는 요소를 제일 오래 참조가 안된 것(LRU) 맨 뒤에 있는 요소를 최근에 참조된 것(MRU)
# 캐시 크기가 0인 경우 예외처리 필요
# cache hit = 실행시간 1, cache miss = 실행시간 5

def solution(cacheSize, cities):
    time = 0
    cache = []
    # 캐시가 없을 경우

    if cacheSize == 0:  # 캐시 크기가 0인 경우 예외처리가 필요하다.
        return len(cities) * 5 # cache miss 인 경우이므로 실행시간 5를 곱한다.

    for city in cities: # cities 리스트에 있는 도시 하나씩 반복
        # lower() : 소문자로 바꾸는 메소드
        # cache hit
        if city.lower() in cache: # 만약 캐시에 현재 도시가 있다면
            cache.remove(city.lower()) # 캐시에 들어있는 도시 삭제
            cache.append(city.lower()) # 해당 도시를 리스트의 맨 뒤로 보내기
            time += 1 # 실행시간 (cache hit)
            print("캐시"*cache)
            print("캐시에 현재도시 있음"+time)
        # cache miss
        else: # 만약 캐시에 없다면
            if len(cache) == cacheSize: # 캐시 사이즈와 캐시 길이가 같다면 (캐시가 꽉찼다면)
                cache.pop(0)  # LRU 알고리즘으로 캐시 교체 (첫번째 데이터 삭제)
            cache.append(city.lower()) # 추가
            time += 5 # 실행시간 (cache miss)

    return time