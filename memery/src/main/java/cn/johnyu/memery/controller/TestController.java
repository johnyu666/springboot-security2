package cn.johnyu.memery.controller;

import cn.johnyu.memery.Book;
import cn.johnyu.memery.vo.CommonResult;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    static List<Book> books;
    static {
        books=new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Book book=new Book(i,"name"+i);
            books.add(book);
        }

    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/books")
    @ResponseBody
    public CommonResult<List<Book> > findAllBooks(){
        CommonResult result=new CommonResult(200,"success",books);
        return result;
    }
    @ResponseBody
    @DeleteMapping("/deleteBook/{id}")
    public CommonResult<Book> deleteBook(@PathVariable("id") int id){
        int index=-1;
        for (int i = 0; i < books.size(); i++) {
            if(id==books.get(i).getId()){
                index=i;
                break;
            }
        }
        books.remove(index);
        Book book=new Book();
        book.setId(id);
        return new CommonResult<>(200,"success",book);
    }
    @ResponseBody
    @RequestMapping(value = "/goLogin")
    public CommonResult<String> goLogin(){
        return new CommonResult<>(401,"您还没有登录","");
    }
    @ResponseBody
    @GetMapping("/success")
    public CommonResult<String> success(){
        return new CommonResult<>(201,"登录成功","");
    }
    @ResponseBody
    @GetMapping("/fail")
    public CommonResult<String> fail(){
        return new CommonResult<>(400,"用户名密码错","");
    }
}
