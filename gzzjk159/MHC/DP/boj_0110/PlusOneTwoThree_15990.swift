
let n: Int = Int(readLine()!)!

var dp: [[Int]] = Array(repeating: Array(repeating: 0, count: 3), count: 100001)
var numArray = [Int]()

for _ in 0..<n {
    numArray.append(Int(readLine()!)!)
}

dp[1] = [1, 0, 0]
dp[2] = [0, 1, 0]
dp[3] = [1, 1, 1]

for i in 4...100000 {
    dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % 1_000_000_009
    dp[i][1] = (dp[i-2][0] + dp[i-2][2]) % 1_000_000_009
    dp[i][2] = (dp[i-3][0] + dp[i-3][1]) % 1_000_000_009
}

for num in numArray {
    print(sum(num) % 1_000_000_009)
}

func sum(_ num: Int) -> Int {
    return dp[num][0] + dp[num][1] + dp[num][2]
}
