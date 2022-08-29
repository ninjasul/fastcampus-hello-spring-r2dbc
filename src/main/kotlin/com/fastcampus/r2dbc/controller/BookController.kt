package com.fastcampus.r2dbc.controller

import com.fastcampus.r2dbc.entity.Book
import com.fastcampus.r2dbc.repository.R2dbcBookRepository
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController("/books")
class BookController(
    val bookRepository: R2dbcBookRepository,
) {
    @GetMapping("/all")
    fun getAll(): Flux<Book> {
        return bookRepository.findAll()
    }

    @GetMapping("/{name}")
    fun getByName(@PathVariable name:String): Mono<Book> {
        return bookRepository.findByName(name)
    }

    @PostMapping("/add")
    fun create(@RequestBody map: Map<String, Any>): Mono<Book> {
        val book = Book(
            name = map["name"].toString(),
            price = map["price"] as Int,
        )

        return bookRepository.save(book)
    }
}