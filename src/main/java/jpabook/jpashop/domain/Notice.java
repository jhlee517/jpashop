package jpabook.jpashop.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Notice extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "notice_id")
    private Long id;
    private String subject;
    private String contents;
    private String name;
    private String viewcnt;

    public Notice(Long id, String subject, String contents, String name, String viewcnt) {
        this.id = id;
        this.subject = subject;
        this.contents = contents;
        this.name = name;
        this.viewcnt = viewcnt;
    }
}
