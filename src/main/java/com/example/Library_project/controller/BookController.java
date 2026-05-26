package com.example.Library_project.controller;

import com.example.Library_project.Service.BookService;
import com.example.Library_project.model.Book;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }
@GetMapping("/{id}")
    public Book getBookbyId(@PathVariable Long id){
        return bookService.getBookById(id);
}
@GetMapping
    public List<Book> getAllBooks(){
return bookService.getAllBooks();
}
@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@Valid @RequestBody Book book){
        return  bookService.createBook(book);
}
@PutMapping("/{id}")
    public  Book updateBook(@PathVariable Long id,@RequestBody @Valid Book book){
        return bookService.updateBook(id,book);
}
@PatchMapping("/{id}")
    public  Book patchBook(@PathVariable Long id,@RequestBody Book book){
        return bookService.patchBook(id,book);
}
@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
}

}
