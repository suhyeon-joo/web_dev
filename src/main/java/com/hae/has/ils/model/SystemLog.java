package com.hae.has.ils.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "system_log", schema = "v4")
public class SystemLog {
    @Id
    @Column(name = "seq", nullable = false)
    private Long id;

    @Size(max = 30)
    @Column(name = "type", length = 30)
    private String type;

    @Size(max = 1000)
    @Column(name = "content_text", length = 1000)
    private String contentText;

    @Column(name = "content_json")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> contentJson;

    @Column(name = "stacktrace", length = Integer.MAX_VALUE)
    private String stacktrace;

    @Column(name = "created_dt")
    private Instant createdDt;

    @Size(max = 50)
    @Column(name = "writer_id", length = 50)
    private String writerId;

    @Size(max = 1)
    @Column(name = "rewrite_flag", length = 1)
    private String rewriteFlag;

    @Size(max = 50)
    @Column(name = "rewriter_id", length = 50)
    private String rewriterId;

}