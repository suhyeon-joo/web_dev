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
public class EsaaurfId implements java.io.Serializable {
    private static final long serialVersionUID = 4801559925332891805L;
    @Size(max = 18)
    @NotNull
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Size(max = 18)
    @NotNull
    @Column(name = "role_cd", nullable = false, length = 18)
    private String roleCd;

    @Size(max = 18)
    @NotNull
    @Column(name = "menu_cd", nullable = false, length = 18)
    private String menuCd;

    @Size(max = 18)
    @NotNull
    @Column(name = "func_cd", nullable = false, length = 18)
    private String funcCd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EsaaurfId entity = (EsaaurfId) o;
        return Objects.equals(this.roleCd, entity.roleCd) &&
                Objects.equals(this.menuCd, entity.menuCd) &&
                Objects.equals(this.sysId, entity.sysId) &&
                Objects.equals(this.funcCd, entity.funcCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleCd, menuCd, sysId, funcCd);
    }

}