package ch.teko.book.service

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LendBookClientTest {


    @Test
    internal fun `when book is available then lend book`() {
        // given
        val bookId = 123
        val memberId = 321
        val bookService = mock<LendBookService>()
        whenever(bookService.inStock(bookId)).thenReturn(true)

        val lendBookClient = LendBookClient(bookService)

        // when
        lendBookClient.checkout(bookId, memberId)

        // then
        verify(bookService).inStock(bookId)
        verify(bookService).lend(bookId, memberId)
    }

    @Test
    internal fun `when book is not available then don't lend book`() {
        val bookId = 123
        val memberId = 321
        val bookService = mock<LendBookService>()
        whenever(bookService.inStock(bookId)).thenReturn(false)

        val lendBookClient = LendBookClient(bookService)

        // when
        lendBookClient.checkout(bookId, memberId)

        // then
        verify(bookService).inStock(bookId)
        verify(bookService, never()).lend(bookId, memberId)
    }
}