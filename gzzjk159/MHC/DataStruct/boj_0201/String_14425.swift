//  algorithm - String_14425.swift
//  created by vetto on 2023/02/01

import Foundation

let input = readLine()!.split(separator: " ").map { Int(String($0))! }

let n = input[0]
let m = input[1]

var stringArray: Set<String> = Set()

for _ in 0..<n {
    stringArray.insert(readLine()!)
}

var result: Int = 0

for _ in 0..<m {
    let string = readLine()!
    
    if stringArray.contains(string) {
        result += 1
    }
}

print(result)
