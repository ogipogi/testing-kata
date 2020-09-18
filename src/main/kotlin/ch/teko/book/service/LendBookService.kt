package ch.teko.book.service

interface LendBookService {
    fun inStock(bookId:Int): Boolean
    fun lend(bookId:Int, memberId:Int)
}
