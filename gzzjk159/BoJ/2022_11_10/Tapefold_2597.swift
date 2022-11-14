//
//  Tapefold_2597.swift
//  algorithm
//
//  Created by 이주명 on 2022/11/05.
//

import Foundation

struct Point {
    var start: Double = 0
    var end: Double = 0
}

func update(mid: Double, num: Double) -> Double {
    return mid + abs(mid - num)
}

func fold(idx: Int) {
    if pointPosition[idx].start == pointPosition[idx].end {
        return
    }
    
    let mid: Double = (pointPosition[idx].start + pointPosition[idx].end)/2
    
    for i in idx+1..<3 {
        pointPosition[i].start = update(mid: mid, num: pointPosition[i].start)
        pointPosition[i].end = update(mid: mid, num: pointPosition[i].end)
    }
    
    tape[0] = update(mid: mid, num: tape[0])
    if tape[0] > tape[1] {
        tape[1] = tape[0]
    }
    tape[0] = mid
}

var tape: [Double] = [Double]()

tape.append(0)
tape.append(Double(readLine()!)!)

var p: Point = Point()
var pointPosition: [Point] = Array(repeating: p, count: 3)

for i in 0...2 {
    let inputpoint = readLine()!.split(separator: " ").map{Double(String($0))!}
    pointPosition[i].start = inputpoint[0]
    pointPosition[i].end = inputpoint[1]
}

for i in 0...2 {
    fold(idx: i)
}

var len: Double = tape[1] - tape[0]

print(String(format: "%.1f", len))
