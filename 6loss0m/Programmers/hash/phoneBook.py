def solution(phone_book):
    phone_book.sort() # 작은수가 앞으로 가서 자동으로 기준점을 잡음 ^^
    for p1, p2 in zip(phone_book, phone_book[1:]):
        # startswith(시작하는문자, 시작지점) : 있으면 true, 없으면 false
        if p2.startswith(p1):
            return False
    return True