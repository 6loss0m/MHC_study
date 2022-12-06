//
//  GasStation.swift

import Foundation

let n: Int = Int(readLine()!)!
let distance = readLine()!.split(separator: " ").map{ Int(String($0))! }
let price = readLine()!.split(separator: " ").map{ Int(String($0))! }

var result: Int = 0
var minPrice: Int = price[0]

for i in 0..<n-1 {
    if minPrice > price[i] {
        minPrice = price[i]
    }
    result += minPrice * distance[i]
}

print(result)
