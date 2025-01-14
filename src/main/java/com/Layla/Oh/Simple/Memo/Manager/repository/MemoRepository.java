package com.Layla.Oh.Simple.Memo.Manager.repository;

import com.Layla.Oh.Simple.Memo.Manager.domain.Memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {

    Memo save(Memo memo);

    Optional<Memo> findById(int id);
    Optional<Memo> findByTitle(String title);
    List<Memo> findAll();

}
