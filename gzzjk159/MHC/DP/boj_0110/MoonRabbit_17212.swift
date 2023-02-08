import Foundation

let n: Int = Int(readLine()!)!

let coins = [1,2,5,7]

var dp: [Int] = Array(repeating: Int.max, count: 100001)
dp[0] = 0

if n != 0{
    for i in 1...n {
        for coin in coins {
            if i - coin >= 0 {
                dp[i] = min(dp[i], dp[i-coin] + 1)
            }
        }
    }
}
print(dp[n])
