package com.fastcampus.r2dbc.repository

import com.fastcampus.r2dbc.entity.Book
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface R2dbcBookRepository : ReactiveCrudRepository<Book, Long> {
    fun findByName(name: String): Mono<Book>
}