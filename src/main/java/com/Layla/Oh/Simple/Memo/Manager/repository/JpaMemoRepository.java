package com.Layla.Oh.Simple.Memo.Manager.repository;

import com.Layla.Oh.Simple.Memo.Manager.domain.Memo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaMemoRepository implements MemoRepository {

    private final EntityManager em;

    @Override
    public Memo save(Memo memo) {
        em.persist(memo);
        return null;
    }

    @Override
    public Optional<Memo> findById(Long id) {
        Memo memo = em.find(Memo.class, id);
        return Optional.ofNullable(memo);
    }

    @Override
    public Optional<Memo> findByTitle(String title) {
        List<Memo> result = em.createQuery("select m from Memo m where m.title = :title", Memo.class)
                .setParameter("title", title)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Memo> findAll() {
        return em.createQuery("select m from Memo m", Memo.class)
                .getResultList();
    }
}
