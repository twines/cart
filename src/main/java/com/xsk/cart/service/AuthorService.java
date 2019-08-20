package com.xsk.cart.service.serviceimp;

import com.xsk.cart.model.Author;

import java.util.List;

public interface AuthorService {
    int insertAuthor(Author author);

    int updateAuthor(Author author);

    List<Author> findAll();

    Author findSomeAuthor(Integer authorId);
}
