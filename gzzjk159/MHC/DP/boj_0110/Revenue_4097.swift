import Foundation

var toggle: Bool = true

while(toggle) {
    let n: Int = Int(readLine()!)!
    
    if n != 0 {
        var array: [Int] = [Int]()
        
        for _ in 0..<n {
            array.append(Int(readLine()!)!)
        }
        
        var dp: [Int] = Array(repeating: Int.min, count: n)
        dp[0] = array[0]
        
        for i in 1..<n {
            dp[i] = max(array[i], dp[i-1] + array[i])
        }
        
        print(maxArray(of: dp))
    } else {
        toggle = false
    }
}

func maxArray(of array: [Int]) -> Int {
    var maxNum = Int.min
    for n in array {
        maxNum = max(maxNum, n)
    }
    return maxNum
}
