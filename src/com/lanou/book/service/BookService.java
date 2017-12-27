package com.lanou.book.service;

import com.lanou.book.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> findByCid(String cid);
    Book findBookByBid(String bid);
    List<Book> findAllBook();

}
