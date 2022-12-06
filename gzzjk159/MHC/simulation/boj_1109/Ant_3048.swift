//
//  Ant_3048.swift
//  algorithm
//
//  Created by 이주명 on 2022/11/05.
//

import Foundation

struct Ant {
    var value: Character = "A"
    var direction: Int = 0
}

let number = readLine()!.split(separator: " ").map{Int(String($0))!}
let n1: Int = number[0]
let n2: Int = number[1]

var ant: Ant = Ant()
var group1: [Ant] = Array(repeating: ant, count: n1)
var group2: [Ant] = Array(repeating: ant, count: n2)

var input = Array(readLine()!)

for i in stride(from: n1-1, through: 0, by: -1) {
    group1[i] = Ant(value: input[n1-i-1], direction: 1)
}

input = Array(readLine()!)

for i in 0..<n2 {
    group2[i] = Ant(value: input[i], direction: -1)
}

var start: [Ant] = [Ant]()
for a1 in group1 {
    start.append(a1)
}
for a2 in group2 {
    start.append(a2)
}

var t: Int = Int(readLine()!)!

var end = start

for _ in 0..<t {
    let cur = end
    for j in 0..<n1+n2-1 {
        if cur[j].direction == 1 && cur[j+1].direction == -1 {
            let temp: Ant = cur[j]
            end[j] = cur[j+1]
            end[j+1] = temp
        } else {
            continue
        }
    }
}

var result: String = ""

for i in 0..<n1+n2 {
    result += String(end[i].value)
}

print(result)
