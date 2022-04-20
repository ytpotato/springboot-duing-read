package com.duing;

import com.duing.entity.Author;
import com.duing.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestApplication {

    @Autowired
    private AuthorService authorService;

    @Test
    public void authorList(){
        List<Author> authors = authorService.list();
        System.out.println(authors);
    }

}
