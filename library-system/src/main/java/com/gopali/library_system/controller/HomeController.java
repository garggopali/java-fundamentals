package com.gopali.library_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // https://upgraded-xylophone-9r47jrwg7x2xvpq-8080.app.github.dev/?writer=ggg&title=hjhj
    // or
    // https://upgraded-xylophone-9r47jrwg7x2xvpq-8080.app.github.dev/?writer=ggg&title=hjhj&isbn=hghgjhj
    // so we are adding /?writer=ggg&title=hjhj&isbn=hghgjhj in the end of url as @requestparam
    // @RequestParam(name = "writer") means if someone sending value as writer or as author
    // @RequestParam(required = false) means its optional if we want to add in url or we can skip without error

    @GetMapping("/")
    private String getHome(@RequestParam String title, @RequestParam(name = "writer") String author,
            @RequestParam(required = false) String isbn) {
        if (isbn == null)
            return "Title: " + title + ", Author: " + author;
        else
            return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }

    // 
    @GetMapping("/{author}") // https://upgraded-xylophone-9r47jrwg7x2xvpq-8080.app.github.dev/author_name
    public String getMethodName(@PathVariable String author) {
        return "welcome - " + author;
    }
    

}
