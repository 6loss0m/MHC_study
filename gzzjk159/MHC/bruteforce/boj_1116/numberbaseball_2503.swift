//
//  numberbaseball.swift

import Foundation

func check(thinkArray: [Int], questionArray: [Int], questionStrike: Int, questionBall: Int) -> Bool {
    var countStrike: Int = 0
    var countBall: Int = 0
    
    for i in 0..<questionArray.count {
        for j in 0..<thinkArray.count {
            if i==j && questionArray[i] == thinkArray[j] {
                countStrike += 1
            } else if questionArray[i] == thinkArray[j] {
                countBall += 1
            }
        }
    }
    if countStrike == questionStrike && countBall == questionBall {
        return true
    }
    return false
}

func intToArr(num: Int) -> [Int] {
    var intArr: [Int] = [Int]()
    var number: Int = num
    while number > 0 {
        intArr.insert(number % 10, at: 0)
        number /= 10
    }
    return intArr
}

var n: Int = Int(readLine()!)!
var question: [[Int]] = [[Int]]()

for _ in 0..<n {
    question.append(readLine()!.split(separator: " ").map{Int(String($0))!})
}

var answerCount: Int = 0

for num in 123...987 {
    var numArray: [Int] = intToArr(num: num)
    
    if numArray.contains(0) {
        continue
    }
    if numArray[0] == numArray[1] || numArray[1] == numArray[2] || numArray[0] == numArray[2] {
        continue
    }
    
    var checkedFinish: Bool = true
    
    for arr in question {
        let questionArr: [Int] = intToArr(num: arr[0])
        
        if check(thinkArray: numArray, questionArray: questionArr, questionStrike: arr[1], questionBall: arr[2]) == false {
            checkedFinish = false
        }
    }
    
    if checkedFinish {
        answerCount += 1
    }
}

print(answerCount)
