package ch.teko.book.service

class LendBookClient(val bookService: LendBookService) {
    fun checkout(bookId: Int, memberId: Int) {
        if (bookService.inStock(bookId)) {
            bookService.lend(bookId, memberId)
        }
    }

}
