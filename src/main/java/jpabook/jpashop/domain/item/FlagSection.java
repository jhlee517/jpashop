package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
@Getter
@Setter
public class FlagSection extends Item {

    private String startPlace;
    private String endPlace;
}
