//  algorithm - EscapeTree_15900.swift
//  created by vetto on 2023/02/01

import Foundation

let n: Int = Int(readLine()!)!

var node: [[Int]] = [[Int]]()

for _ in 0...n {
    node.append([Int]())
}

for _ in 0..<n-1 {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    let a = input[0]
    let b = input[1]
    
    node[a].append(b)
    node[b].append(a)
}

var isVisited: [Bool] = Array(repeating: false, count: n+1)
var answer = 0

dfs(index: 1, count: 0, visited: &isVisited)
print((answer % 2 == 0) ? "No" : "Yes")

func dfs(index: Int, count: Int, visited: inout [Bool]) {
    visited[index] = true
    
    for i in node[index] {
        if !visited[i] {
            dfs(index: i, count: count + 1, visited: &visited)
        }
    }
    
    if index != 1 && node[index].count == 1 {
        answer += count
    }
}
