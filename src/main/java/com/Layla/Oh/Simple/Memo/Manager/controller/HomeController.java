package com.Layla.Oh.Simple.Memo.Manager.controller;

import com.Layla.Oh.Simple.Memo.Manager.domain.Memo;
import com.Layla.Oh.Simple.Memo.Manager.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final MemoService memoService;

    public HomeController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Memo> allMemo = memoService.findAllMemo();
        model.addAttribute(allMemo);
        return "home";
    }
}
