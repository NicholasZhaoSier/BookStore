package com.lanou.book.dao;

import com.lanou.book.domain.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAllBook();
    List<Book> findByCid(String cid);
    Book findBookByBid(String bid);

}
