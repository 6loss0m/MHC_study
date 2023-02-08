
var dp: [Int] = Array(repeating: 01, count: 51)

let n = Int(readLine()!)!

for index in 2...50 {
    dp[index] = (dp[index-1]+dp[index-2]+1) % 1_000_000_007
}

print(dp[n])
