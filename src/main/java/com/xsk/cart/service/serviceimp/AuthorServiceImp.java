package com.xsk.cart.service.serviceimp;

import com.xsk.cart.mapper.AuthorMapper;
import com.xsk.cart.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImp implements com.xsk.cart.service.serviceimp.AuthorService {
    @Autowired
    AuthorMapper authorMapper;

    @Override
    public int insertAuthor(Author author) {
        return authorMapper.insertAuthor(author);
    }

    @Override
    public int updateAuthor(Author author) {
        return authorMapper.updateAuthor(author);
    }

    @Override
    public List<Author> findAll() {
        return authorMapper.findAll();
    }

    @Override
    public Author findSomeAuthor(Integer authorId) {
        return authorMapper.findSomeAuthor(authorId);
    }
}
