package com.test.shoppingCartAPI;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class CartController {

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }


}