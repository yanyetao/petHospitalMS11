package com.yyt;

import com.yyt.dao.BookDao;
import com.yyt.dao.impl.BookDaoImpl;
import com.yyt.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        //3.获取IoC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //4.获取bean（根据bean配置id获取）
//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//        bookDao.save();

//        BookService bookService = (BookService) ctx.getBean("bookService");
//        bookService.save();
        BookDao bookDao =(BookDao) ctx.getBean("bookDao");
        bookDao.save();

    }
}
