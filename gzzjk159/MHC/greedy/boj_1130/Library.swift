//
//  Library.swift

import Foundation

var n: Int = Int(readLine()!)!

var books: [Int] = [Int]()

for _ in 0..<n {
    books.append(Int(readLine()!)!)
}
books.reverse()

var noSortBook = n - 1
let bookPosition = books.firstIndex(of: n)!

var booksSortCount = n - 1

for i in (bookPosition + 1)..<n {
    if books[i] == noSortBook {
        noSortBook = books[i] - 1
        booksSortCount -= 1
    }
}

print(booksSortCount)
