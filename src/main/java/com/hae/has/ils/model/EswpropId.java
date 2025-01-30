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
public class EswpropId implements java.io.Serializable {
    private static final long serialVersionUID = -8629465729800996582L;
    @Size(max = 18)
    @NotNull
    @Column(name = "sys_id", nullable = false, length = 18)
    private String sysId;

    @Size(max = 50)
    @NotNull
    @Column(name = "usr_id", nullable = false, length = 50)
    private String usrId;

    @Size(max = 36)
    @NotNull
    @Column(name = "wdgt_id", nullable = false, length = 36)
    private String wdgtId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EswpropId entity = (EswpropId) o;
        return Objects.equals(this.sysId, entity.sysId) &&
                Objects.equals(this.wdgtId, entity.wdgtId) &&
                Objects.equals(this.usrId, entity.usrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sysId, wdgtId, usrId);
    }

}