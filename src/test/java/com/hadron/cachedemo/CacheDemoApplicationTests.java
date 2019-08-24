package com.hadron.cachedemo;

import com.hadron.cachedemo.entity.Book;
import com.hadron.cachedemo.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheDemoApplicationTests {
    @Autowired
    private BookService bookService;

    @Test
    public void contextLoads() {
        List<Book> list = bookService.list();
        list.forEach(System.out::println);

    }

}
