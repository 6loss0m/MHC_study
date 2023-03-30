//  algorithm - Warehouse.swift
//  created by vetto on 2023/01/25

let n: Int = Int(readLine()!)!
var pillar = [[Int]]()
var answer = 0

for _ in 0..<n {
    pillar.append(readLine()!.split(separator: " ").map { Int(String($0))! })
}

pillar.sort(by: { $0[0] < $1[0] })

var highIndex = 0

for i in 0..<pillar.count {
    if pillar[i][1] > answer {
        answer = pillar[i][1]
        highIndex = i
    }
}

var height = pillar[0][1]

for i in 0..<highIndex {
    if height < pillar[i+1][1] {
        answer += height * (pillar[i+1][0] - pillar[i][0])
        height = pillar[i+1][1]
    } else {
        answer += height * (pillar[i+1][0] - pillar[i][0])
    }
}

height = pillar[pillar.count-1][1]

for i in stride(from: n-1, to: highIndex, by: -1) {
    if height < pillar[i-1][1] {
        answer += height * (pillar[i][0] - pillar[i-1][0])
        height = pillar[i-1][1]
    } else {
        answer += height * (pillar[i][0] - pillar[i-1][0])
    }
}

print(answer)
