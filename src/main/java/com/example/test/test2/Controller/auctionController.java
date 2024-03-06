package com.example.test.test2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class auctionController {

    @GetMapping("/auction/calc")
    public String getMethodName(Model model) {

        return "/auction";
    }

}
