
import Foundation

let n: Int = Int(readLine()!)!

let t: Int = Int(readLine()!)!

var path: [[Int]] = [[Int]]()

for _ in 0...n {
    path.append([])
}

for _ in 0..<t {
    let input = readLine()!.split(separator: " ").map{Int(String($0))!}
    path[input[0]].append(input[1])
    path[input[1]].append(input[0])
}

var worm: [Bool] = Array(repeating: false, count: n+1)
worm[0] = true

func dfs(_ num: Int) {
    worm[num] = true
    
    for i in path[num] {
        if worm[i] == false {
            dfs(i)
        }
    }
}

dfs(1)

var answer: Int = n-1

for i in 1...n {
    if worm[i] == false {
        answer -= 1
    }
}

print(answer)
