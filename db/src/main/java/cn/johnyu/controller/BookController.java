package cn.johnyu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @RequestMapping("/books")
    public String findAllBooks(){
        return "all books";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
