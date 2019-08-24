package com.hadron.cachedemo.controllet;

import com.hadron.cachedemo.entity.Book;
import com.hadron.cachedemo.service.BookService;
import com.hadron.cachedemo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Hadron
 * @date 2019/8/21 11:48
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books",produces = "application/json;charset=utf-8")
    public List<Book> books(){
        return bookService.list();
    }

    @GetMapping(value = "/book/{id}",produces = "application/json;charset=utf-8")
    public Book book(@PathVariable Long id){
        return bookService.getOne(id);
    }
    @PutMapping(value = "/books",produces = "application/json;charset=utf-8")
    public Book update(Book book){
        return bookService.update(book);
    }
    @DeleteMapping(value = "/book/{id}",produces = "application/json;charset=utf-8")
    public Result remove(@PathVariable Long id){
        boolean remove = bookService.remove(id);
        return new Result("success",remove);
    }
}
