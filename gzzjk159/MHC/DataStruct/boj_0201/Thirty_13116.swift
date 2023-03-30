//  algorithm - Thirty.swift
//  created by vetto on 2023/02/01

import Foundation

let n = Int(readLine()!)!

for _ in 0..<n {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    var a = input[0]
    var b = input[1]
    
    while true {
        if a == b {
            print(a*10)
            break
        }
        
        if a > b {
            a /= 2
        } else {
            b /= 2
        }
    }
}
