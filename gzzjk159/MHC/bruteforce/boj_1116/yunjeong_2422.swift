//
//  yunjeong_2422.swift

import Foundation

let input: [Int] = readLine()!.split(separator: " ").map{Int(String($0))!}

let n: Int = input[0]
let m: Int = input[1]
var check: [[Bool]] = Array(repeating: Array(repeating: false, count: 201), count: 201)


for _ in 0..<m {
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    check[input[0]][input[1]] = true
    check[input[1]][input[0]] = true
}

var answer: Int = 0

for i in 1...n-2 {
    for j in i+1...n-1 {
        for k in j+1...n {
            if check[i][j] || check[j][k] || check[i][k] {
                continue
            }
            answer += 1
        }
    }
}

print(answer)
