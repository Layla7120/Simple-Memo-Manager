package com.Layla.Oh.Simple.Memo.Manager.service;

import com.Layla.Oh.Simple.Memo.Manager.domain.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemoServiceTest {

    @Autowired
    MemoService memoService;

    @Test
    void saveMemo() {
        Memo memo = new Memo();
        String title = "test title";
        memo.setTitle(title);
        memo.setContent("test content");

        Long saveMemo = memoService.saveMemo(memo);

        Memo memoByTitle = memoService.findMemoById(saveMemo).get();
        assertThat(memo.getTitle()).isEqualTo(memoByTitle.getTitle());
    }

    @Test
    void DuplicateMemoTitle() {
        Memo memo1 = new Memo();
        memo1.setTitle("test title");
        memo1.setContent("test content");

        Memo memo2 = new Memo();
        memo2.setTitle("test title");
        memo2.setContent("test content");

        memoService.saveMemo(memo1);
        assertThrows(IllegalStateException.class, () -> memoService.saveMemo(memo2));
    }

    @Test
    void findAllMemo() {
        Memo memo1 = new Memo();
        memo1.setTitle("test title");
        memo1.setContent("test content");

        Memo memo2 = new Memo();
        memo2.setTitle("test title");
        memo2.setContent("test content");

        List<Memo> allMemo = memoService.findAllMemo();
        assertThat(allMemo).hasSize(2);
    }

    @Test
    void findMemoByTitle() {
        Memo memo = new Memo();
        memo.setTitle("test title");
        memo.setContent("test content");

        memoService.saveMemo(memo);

        Memo memoByTitle = memoService.findMemoByTitle("test title").get();
        assertThat(memoByTitle.getTitle()).isEqualTo(memo.getTitle());
    }
}