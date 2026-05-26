package com.example.Library_project.Service;

import com.example.Library_project.model.Book;
import com.example.Library_project.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{
private final BookRepository bookRepository;
public BookService(BookRepository bookRepository){
    this.bookRepository=bookRepository;
}
public List<Book> getAllBooks(){
return bookRepository.findAll();
}
public Book createBook(Book book){
    return bookRepository.save(book);
}
public Book getBookById(Long id){
    return bookRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Error"));
}
public Book updateBook(Long id,Book updatedbook){
    Book existingbook=bookRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Error"));
    existingbook.setBookname(updatedbook.getBookname());
    existingbook.setDescription(updatedbook.getDescription());
    existingbook.setFinished(updatedbook.getFinished());
    return bookRepository.save(existingbook);
}
public Book patchBook(Long id,Book updatedbook){
    Book existingbook=bookRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Error"));
    if (updatedbook.getBookname()!=null){
        existingbook.setBookname(updatedbook.getBookname());
    }
    if(updatedbook.getDescription()!=null){
        existingbook.setDescription(updatedbook.getDescription());
    }
    if (updatedbook.getFinished()!=null){
        existingbook.setFinished(updatedbook.getFinished());
    }
    return bookRepository.save(existingbook);
}
public void deleteBook(Long id){
    Book existingbook=bookRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Error"));
    bookRepository.delete(existingbook);
}


    }






