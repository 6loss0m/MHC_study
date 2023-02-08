
import Foundation

func dfs(_ idx: Int) {
    if idx == len {
        result = 1
    }
    
    if visit[idx] { return }
    
    visit[idx] = true
    
    for i in 0..<n {
        if len - idx < words[i].count { continue }
        if words[i] == s[idx..<idx+words[i].count].joined(separator: "") {
            dfs(idx + words[i].count)
        }
    }
}

let s = Array(readLine()!).map{String($0)}
let len = s.count
let n = Int(readLine()!)!

var words = [String]()
for _ in 0..<n {
    words.append(readLine()!)
}
var result = 0
var visit = Array(repeating: false, count: len+1)

dfs(0)
print(result)
