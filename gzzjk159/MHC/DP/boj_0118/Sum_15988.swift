import Foundation

var t: Int = Int(readLine()!)!

var dp: [Int] = [Int]()

dp.append(0)
dp.append(1)
dp.append(2)
dp.append(4)

for i in 4..<1000001 {
    dp.append((dp[i-1]+dp[i-2]+dp[i-3]) % 1000000009)
}
for _ in 0..<t {
    var n: Int = Int(readLine()!)!
    
    print(dp[n])
}
