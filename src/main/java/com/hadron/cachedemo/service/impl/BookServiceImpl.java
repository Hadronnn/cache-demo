package com.hadron.cachedemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hadron.cachedemo.entity.Book;
import com.hadron.cachedemo.mapper.BookMapper;
import com.hadron.cachedemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Hadron
 * @date 2019/8/15 14:26
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> list() {
        return bookMapper.selectList(null);
    }

    @Override
    //将查询结果进行缓存
    //Cacheable：当缓存中已存在，直接从缓存中读取数据，如果不存在，将返回结果存入缓存
    //unless:不进行缓存的恶条件
    @Cacheable(cacheNames = "book",key = "'book-'+#id",unless = "#result == null")
    public Book getOne(Long id) {
        return bookMapper.selectById(id);
    }

    @Override
    //CachePut：无论缓存中是否存在，将缓存的数据存入缓存
    @CachePut(cacheNames = "book",key = "'book'+#book.bookId")
    public Book update(Book book) {
        int i = bookMapper.updateById(book);
        return getOne(book.getBookId());
    }

    @Override
    @CacheEvict(cacheNames = "book",key = "'book-'+#id")
    public boolean remove(Long id) {
        int i = bookMapper.deleteById(id);
        return i==1;
    }
}
