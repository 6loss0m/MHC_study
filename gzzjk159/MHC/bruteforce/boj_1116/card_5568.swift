
import Foundation

var n: Int = Int(readLine()!)!

var k: Int = Int(readLine()!)!

var numArray: [Int] = [Int]()

for _ in 0..<n {
    numArray.append(Int(readLine()!)!)
}
var numSet: Set<Int> = Set<Int>()

func pickCard(targetCount: Int, visit: [Bool], cardData: [Int]) {
    if targetCount == k {
        var result: String = ""
        for card in cardData {
            result += String(card)
        }
        numSet.insert(Int(result)!)
        return
    }
    for i in 0..<numArray.count {
        var visited = visit
        if visit[i] == false {
            visited[i] = true
            var newCardData = cardData
            newCardData.append(numArray[i])
            pickCard(targetCount: targetCount+1, visit: visited, cardData: newCardData)
            visited[i] = false
        }
    }
}

let visited: [Bool] = [Bool](repeating: false, count: numArray.count)
pickCard(targetCount: 0, visit: visited, cardData: [Int]())

print(numSet.count)

