package com.example.generationlego.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/confermapagamento")
public class ConfermaPagamentoController {
    @GetMapping
    public String getPage(
            HttpSession session,
            Model model,
            @RequestParam(name = "send", required = false) String send
    ){
        return "confermapagamento";
    }
}
