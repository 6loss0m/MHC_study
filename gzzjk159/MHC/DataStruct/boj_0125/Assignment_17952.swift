//  algorithm - Assignment_17952.swift
//  created by vetto on 2023/01/25

let n = Int(readLine()!)!
var stack = [[Int]]()
var answer = 0

for _ in 0..<n {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    if input[0] == 1 {
        if input[2] == 1 {
            answer += input[1]!
        } else {
            stack.append([input[1]!, input[2]!-1])
        }
        continue
    }
    if !stack.isEmpty {
        let len = stack.count - 1
        stack[len][1] -= 1
        if stack[len][1] == 0 {
            answer += stack[len][0]
            stack.remove(at: len)
        }
    }
}

print(answer)
