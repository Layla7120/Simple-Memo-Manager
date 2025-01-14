package com.Layla.Oh.Simple.Memo.Manager.controller;

import com.Layla.Oh.Simple.Memo.Manager.domain.Memo;
import com.Layla.Oh.Simple.Memo.Manager.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @GetMapping("/memo/new")
    public String createForm(){
        return "memo/createMemoForm";
    }

    @PostMapping("/memo/new")
    public String create(MemoForm memoForm){
        Memo memo = new Memo();
        memo.setTitle(memoForm.getTitle());
        memo.setContent(memoForm.getContent());

        memoService.saveMemo(memo);

        return "redirect:/";
    }
}
