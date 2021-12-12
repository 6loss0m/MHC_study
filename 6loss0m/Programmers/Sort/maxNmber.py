def solution(numbers):
    # map(type,변수)
    numbers = list(map(str, numbers))
    #com = lambda x : x+10
    #com(1) -> 11
    numbers.sort(key=lambda x: x * 3, reverse=True)
    # 3 30 34 -> 34 3 30
    # ['6', '2', '10'] 
    # '6-2-10'
    # '000000'
    return str(int(''.join(numbers)))

'''
import functools

def comparator(a,b):
    t1 = a+b
    t2 = b+a
    return (int(t1) > int(t2)) - (int(t1) < int(t2)) #  t1이 크다면 1  // t2가 크다면 -1  //  같으면 0

def solution(numbers):
    n = [str(x) for x in numbers]
    n = sorted(n, key=functools.cmp_to_key(comparator),reverse=True)
    answer = str(int(''.join(n)))
    return answer
'''