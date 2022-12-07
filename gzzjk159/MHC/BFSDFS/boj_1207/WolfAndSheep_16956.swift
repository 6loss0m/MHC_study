
import Foundation

let input = readLine()!.split(separator: " ").map{Int(String($0))!}

let r: Int = input[0]
let c: Int = input[1]

var map: [[String]] = [[String]]()

for _ in 0..<r {
    map.append(Array(readLine()!.map{String($0)}))
}

let dx = [1,-1,0,0]
let dy = [0,0,1,-1]

var check = false

loop: for i in 0..<r {
    for j in 0..<c {
        if map[i][j] == "W" {
            for k in 0..<4 {
                var nx = i + dx[k]
                var ny = j + dy[k]
                
                if nx<0 || ny<0 || nx>=r || ny>=c {
                    continue
                }
                if map[nx][ny] == "S" {
                    check = true
                    break loop
                }
            }
        }
    }
}

if check {
    print(0)
} else {
    print(1)
    for i in 0..<r {
        for j in 0..<c {
            if map[i][j] == "." {
                map[i][j] = "D"
            }
        }
    }
    for m in map {
        print(m.joined(separator: ""))
    }
}
