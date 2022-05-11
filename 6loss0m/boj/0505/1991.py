# 트리순회

# preorder(전위순회) = (루트)(왼쪽자식)(오른쪽자식)
#
# inorder(중위순회) = (왼쪽자식)(루트)(오른쪽자식)
#
# postorder(후위순회) = (왼쪽자식)(오른쪽자식)(루트)
import sys

input = sys.stdin.readline
N = int(input())
tree = {}
for _ in range(N):
    root, left, right = input().split()
    tree[root] = [left,right]


def preorder(root):
    if root != '.':
        print(root,end='')
        preorder(tree[root][0])
        preorder(tree[root][1])

def inorder(root):
    if root != '.':
        inorder(tree[root][0])
        print(root, end='')
        inorder(tree[root][1])

def postorder(root):
    if root != '.':
        postorder(tree[root][0])
        postorder(tree[root][1])
        print(root, end='')

preorder('A')
print()
inorder('A')
print()
postorder('A')