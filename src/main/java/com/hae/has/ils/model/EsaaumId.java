package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EsaaumId implements java.io.Serializable {
    private static final long serialVersionUID = -2063732405097883343L;
    @Size(max = 18)
    @NotNull
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Size(max = 18)
    @NotNull
    @Column(name = "menu_cd", nullable = false, length = 18)
    private String menuCd;

    @Size(max = 200)
    @NotNull
    @Column(name = "call_ptrn", nullable = false, length = 200)
    private String callPtrn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EsaaumId entity = (EsaaumId) o;
        return Objects.equals(this.menuCd, entity.menuCd) &&
                Objects.equals(this.sysId, entity.sysId) &&
                Objects.equals(this.callPtrn, entity.callPtrn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuCd, sysId, callPtrn);
    }

}