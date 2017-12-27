package com.lanou.book.dao.impl;

import com.lanou.book.dao.BookDao;
import com.lanou.book.domain.Book;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDaoImpl implements BookDao {
QueryRunner queryRunner = new GxQueryRunner();

    @Override
    public List<Book> findAllBook() {
        List<Book> bookList = new ArrayList<>();
        String sql = "select * from book";

        try {
            bookList = queryRunner.query(sql,new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> findByCid(String cid) {
        List<Book> bookList = new ArrayList<>();
        String sql = "select book.* from book,category where book.cid = category.cid and category.cid = ?";
        try {
            bookList = queryRunner.query(sql,new BeanListHandler<>(Book.class),cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    @Override
    public Book findBookByBid(String bid) {
        Book book = new Book();
        String sql = "select * from book where bid = ?";
        try {
            book = queryRunner.query(sql,new BeanHandler<>(Book.class),bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }
}
