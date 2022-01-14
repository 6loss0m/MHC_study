from itertools import permutations

def solution(expression):
    op = ['+', '-', '*']
    op = list(permutations(op, 3))
    result=[]
    
    for i in op:
        result.append(calculate(expression, i))
        
    return max(result)

def operation(num1, num2, op): # 수식의 개수 3개
    if op == '+': # +를 만나는 경우 더하기 
        return str(int(num1) + int(num2))
    if op == '-': # -를 만나는 경우 더하기 
        return str(int(num1) - int(num2))
    if op == '*': # *를 만나는 경우 더하기 
        return str(int(num1) * int(num2))
    
def calculate( exp, op ): # 계산하기
    array = []
    tmp = ""
    for i in exp: 
        if i.isdigit() == True: # isdigit : 알파벳/숫자인지 확인
            tmp += i # i가 숫자라면 tmp = tmp + i
        else: # 문자라면 
            array.append(tmp) # tmp 값 추가
            array.append(i) # i 값 추가
            tmp = "" # tmp 값 비우기 
    array.append(tmp) # tmp 추가
    
    for o in op: # 
        stack = [] 
        while len(array)!=0: # array의 길이 값이 0이 아니면 반복
            tmp = array.pop(0) # 스택에 저장된 첫번째 원소 pop 
            if tmp == o: 
                stack.append(operation(stack.pop(), array.pop(0), o))
            else: 
                stack.append(tmp)
        array=stack
            
    return abs(int(array[0]))