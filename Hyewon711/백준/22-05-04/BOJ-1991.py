# BOJ 1991 - 트리 순회
# 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현한다.

n = int(input()) # 이진트리 노드 수
inputs = []
for _ in range(n): # 노드 개수만큼 반복
    inputs.append(input().split())

class Node(): #
    # def __init__ = 컨스트럭터라고 불리는 초기화를 위한 함수(메소드)
    # 인스턴스화를 실시할 때 반드시 처음에 호출되는 특수한 함수
    # 오브젝트 생성(인스턴스를 생성)과 관련하여 데이터의 초기를 실시하는 함수
    def __init__(self, item, left, right):
        self.item = item
        self.left = left
        self.right = right

# 소스코드 구현시 전위, 중위, 후위는 print의 위치만 바뀐다.

def preorder(node): # 전위 순회 ( 루트 → 왼쪽 → 오른쪽 ) 자식노드가 없지않은 경우 if문에 계속 들어간다.
    print(node.item, end = '')
    if node.left != '.':
        preorder(tree[node.left])
    if node.right != '.':
        preorder(tree[node.right])

def inorder(node): # 중위 순회 ( 왼쪽 → 루트 → 오른쪽 )
    if node.left != '.':
        inorder(tree[node.left])
    print(node.item, end = '')
    if node.right != '.':
        inorder(tree[node.right])

def postorder(node): # 후위 순회 ( 왼쪽 → 오른쪽 → 루트 )
    if node.left != '.':
        postorder(tree[node.left])
    if node.right != '.':
        postorder(tree[node.right])
    print(node.item, end = '')

tree = {}
for item, left, right in inputs:
    tree[item] = Node(item, left, right)

preorder(tree['A'])
print() # 줄바꿈
inorder(tree['A'])
print() # 줄바꿈
postorder(tree['A'])

