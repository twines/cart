package com.xsk.cart.controller;

import com.xsk.cart.model.Author;
import com.xsk.cart.service.serviceimp.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping(value = "/author/{authorId}")
    public ModelAndView someAuthor(@PathVariable("authorId") long authorId,
                                   @RequestParam("userName") String userName,
                                   Map values) {

        List<Author> authors = authorService.findAll();
        values.put("authors", authors);
        values.put("name", userName);
        ModelAndView modelAndView = new ModelAndView("author", values);
        return modelAndView;
    }
}
