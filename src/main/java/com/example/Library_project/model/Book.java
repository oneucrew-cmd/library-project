package com.example.Library_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Book {
    @Id
    @GeneratedValue
private Long id;
    @NotBlank(message = "Book name cannot be empty!!")
    private String bookname;
    private String description;
    @NotNull(message = "Status finished is required")
    private Boolean finished;
public  Long getId(){
    return id;
}
public  void  setId(Long id){
    this.id=id;
}
public String getBookname(){
    return bookname;
}
public void setBookname(String bookname){
    this.bookname=bookname;
}
public String getDescription(){
    return  description;
}
public void setDescription(String description){
    this.description=description;
}
public Boolean getFinished(){
    return finished;
}
public void setFinished(Boolean finished){
    this.finished=finished;
}
}



