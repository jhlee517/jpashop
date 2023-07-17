package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Notice;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class NoticeRepository {
    private final EntityManager em;
    private final JdbcTemplate jdbcTemplate;

    public void save(Notice notice) {
        if (notice.getId() == null) {
            em.persist(notice);
        } else {
            em.merge(notice);
        }
    }

    public Notice findOne(Long id) {
        return em.find(Notice.class, id);
    }


    public List<Notice> findAll() {
        return em.createQuery("select n from Notice n", Notice.class)
                .getResultList();
    }

    public void updateViewCnt(Long uid) {
        jdbcTemplate.update("update Notice set viewcnt = viewcnt + 1 where notice_id = ?", uid);
    }

    public List<Notice> findByName(String subject) {
        return em.createQuery("select n from Notice n where n.subject = :subject", Notice.class)
                .setParameter("subject", subject)
                .getResultList();
    }
}
