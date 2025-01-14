package com.Layla.Oh.Simple.Memo.Manager.service;

import com.Layla.Oh.Simple.Memo.Manager.repository.MemoRepository;
import com.Layla.Oh.Simple.Memo.Manager.domain.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long saveMemo(Memo memo) {
        validateDuplicateMemo(memo);
        memoRepository.save(memo);
        return memo.getId();
    }

    private void validateDuplicateMemo(Memo memo) {
        memoRepository.findByTitle(memo.getTitle())
                .ifPresent(m -> {
                    throw new IllegalStateException("Memo with title " + memo.getTitle() + " already exists");
                });
    }

    public List<Memo> findAllMemo() {
        return memoRepository.findAll();
    }

    public Optional<Memo> findMemoByTitle(String title) {
        return memoRepository.findByTitle(title);
    }


}
