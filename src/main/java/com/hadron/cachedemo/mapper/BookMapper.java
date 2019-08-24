package com.hadron.cachedemo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hadron.cachedemo.entity.Book;
import org.springframework.stereotype.Component;

/**
 * @Author Hadron
 * @date 2019/8/15 14:25
 */
@Component
public interface BookMapper extends BaseMapper<Book> {
}
