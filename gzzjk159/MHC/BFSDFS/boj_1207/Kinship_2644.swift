
import Foundation

let n: Int = Int(readLine()!)!

let kinship = readLine()!.split(separator: " ").map{Int(String($0))!}

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

var visited: [Int] = Array(repeating: 0, count: n+1)

func bfs(num: Int) {
    var queue: [Int] = [Int]()
    queue.append(num)
    
    while !queue.isEmpty {
        let now = queue[0]
        queue.remove(at: 0)
        for next in path[now] {
            if visited[next] == 0 {
                visited[next] = visited[now] + 1
                queue.append(next)
            }
        }
    }
}
bfs(num: kinship[0])

if visited[kinship[1]] == 0 {
    print(-1)
} else {
    print(visited[kinship[1]])
}
