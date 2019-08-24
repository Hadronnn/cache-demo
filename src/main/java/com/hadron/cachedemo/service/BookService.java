package com.hadron.cachedemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hadron.cachedemo.entity.Book;

import java.util.List;

/**
 * @Author Hadron
 * @date 2019/8/15 14:26
 */
public interface BookService {

    List<Book> list();

    Book getOne(Long id);

    Book update(Book book);

    boolean remove(Long id);
}
