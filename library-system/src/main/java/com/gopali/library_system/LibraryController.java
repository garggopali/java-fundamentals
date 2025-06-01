package com.gopali.library_system;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LibraryController {
    @GetMapping("gopali")
    String hello(){
        return "Hello World!";
    }
}
