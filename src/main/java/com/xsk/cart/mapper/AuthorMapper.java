package com.xsk.cart.mapper;

import com.xsk.cart.model.Author;

import java.util.List;

public interface AuthorMapper {
    int insertAuthor(Author author);

    int updateAuthor(Author author);

    List<Author> findAll();

    Author findSomeAuthor(Integer authorId);
}
