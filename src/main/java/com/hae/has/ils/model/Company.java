package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "company", schema = "v4")
public class Company {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Size(max = 20)
    @Column(name = "serial_number", length = 20)
    private String serialNumber;

    @Size(max = 400)
    @Column(name = "address", length = 400)
    private String address;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @ColumnDefault("'Y'")
    @Column(name = "use_flag", length = Integer.MAX_VALUE)
    private String useFlag;

    @Size(max = 50)
    @Column(name = "writer_id", length = 50)
    private String writerId;

    @ColumnDefault("now()")
    @Column(name = "created_dt")
    private Instant createdDt;

    @ColumnDefault("now()")
    @Column(name = "updated_dt")
    private Instant updatedDt;

    @Column(name = "property")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> property;

    @Size(max = 18)
    @Column(name = "fido_prefix", length = 18)
    private String fidoPrefix;

    @Size(max = 18)
    @Column(name = "fido_company", length = 18)
    private String fidoCompany;

    @Column(name = "otp_yn", length = Integer.MAX_VALUE)
    private String otpYn;

    @Column(name = "fido_yn", length = Integer.MAX_VALUE)
    private String fidoYn;

}