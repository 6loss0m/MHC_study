#BOJ 1924 - 2007년
from datetime import datetime, date

n, m = map(int, input().split())
dateDict = {0: 'MON', 1:'TUE', 2:'WED', 3:'THU', 4:'FRI', 5:'SAT', 6:'SUN'}


print(dateDict[datetime.weekday(date(2007, n, m))])
