package com.lanou.book.service.impl;

import com.lanou.book.dao.impl.BookDaoImpl;
import com.lanou.book.domain.Book;
import com.lanou.book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDaoImpl bookDao = new BookDaoImpl();

    @Override
    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }


    @Override
    public List<Book> findByCid(String cid) {
        return bookDao.findByCid(cid);
    }

    @Override
    public Book findBookByBid(String bid) {
        return bookDao.findBookByBid(bid);
    }

}
