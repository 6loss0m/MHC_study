//
//  King_1063.swift
//  algorithm
//
//  Created by 이주명 on 2022/11/05.
//

import Foundation

struct Point {
    var i: Int = 0
    var j: Int = 0
}

var input = readLine()!.components(separatedBy: " ")

var commandNumber: Int = Int(input[2])!

var input1 = Array(input[0])
var input2 = Array(input[1])

var king_i = wherePoint(input: input1[0])
var king_j = wherePoint(input: input1[1])
var stone_i = wherePoint(input: input2[0])
var stone_j = wherePoint(input: input2[1])

var king: Point = Point(i: king_i, j: king_j)
var stone: Point = Point(i: stone_i, j: stone_j)


for _ in 0..<commandNumber {
    let command = readLine()!
    
    let nextKing = nextObjectMove(object: king, move: command)
    
    if canMove(object: nextKing) {
        if nextKing.i == stone.i && nextKing.j == stone.j {
            let nextStone = nextObjectMove(object: stone, move: command)
            if canMove(object: nextStone) {
                king.i = nextKing.i
                king.j = nextKing.j
                stone.i = nextStone.i
                stone.j = nextStone.j
            } else {
                continue
            }
        } else {
            king.i = nextKing.i
            king.j = nextKing.j
        }
    }
}

print(intToString(input: king.i) + String(king.j))
print(intToString(input: stone.i) + String(stone.j))

func canMove(object: Point) -> Bool {
    if object.i < 1 || object.j < 1 || object.i > 8 || object.j > 8 {
        return false
    } else {
        return true
    }
}

func nextObjectMove(object: Point, move: String) -> Point {
    var nextObject: Point = object
    switch move {
    case "R":
        nextObject.i += 1
    case "L":
        nextObject.i -= 1
    case "B":
        nextObject.j -= 1
    case "T":
        nextObject.j += 1
    case "RT":
        nextObject.i += 1
        nextObject.j += 1
    case "LT":
        nextObject.i -= 1
        nextObject.j += 1
    case "RB":
        nextObject.i += 1
        nextObject.j -= 1
    default:    // "LB"
        nextObject.i -= 1
        nextObject.j -= 1
    }
    return nextObject
}

func wherePoint(input: Character) -> Int {
    switch input {
    case "A","1":
        return 1
    case "B","2":
        return 2
    case "C","3":
        return 3
    case "D","4":
        return 4
    case "E","5":
        return 5
    case "F","6":
        return 6
    case "G","7":
        return 7
    default:
        return 8
    }
}

func intToString(input: Int) -> String {
    switch input {
    case 1:
        return "A"
    case 2:
        return "B"
    case 3:
        return "C"
    case 4:
        return "D"
    case 5:
        return "E"
    case 6:
        return "F"
    case 7:
        return "G"
    default:
        return "H"
    }
}
