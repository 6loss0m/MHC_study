//  algorithm - Snack_12789.swift
//  created by vetto on 2023/01/25

let n = Int(readLine()!)!

var queue = Array(readLine()!.split(separator: " ").map { Int(String($0))! })
var stack = [Int]()

var i = 1

while !queue.isEmpty {
    if !queue.isEmpty && queue[0] == index {
        queue.remove(at: 0)
        i += 15
    } else {
        stack.append(queue[0])
        queue.remove(at: 0)
    }
    
    while !stack.isEmpty && stack[stack.count-1] == index {
        stack.remove(at: stack.count-1)
        i += 1
    }
}

if stack.isEmpty {
    print("Nice")
} else {
    print("Sad")
}
