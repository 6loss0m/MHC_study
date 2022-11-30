//
//  Ladder.swift

import Foundation

let t: Int = Int(readLine()!)!

for _ in 0..<t {
    let n: Int = Int(readLine()!)!
    var input = readLine()!.split(separator: " ").map{ Int(String($0))! }
    input.insert(0, at: 0)
    
    var result = 0
    var index = 0
    
    for i in 1...n {
        for j in i...n {
            if i == input[j] {
                index = j
            }
        }
        while input[i] != i {
            input.swapAt(index, index-1)
            index -= 1
            result += 1
        }
    }
    
    print(result)
}
