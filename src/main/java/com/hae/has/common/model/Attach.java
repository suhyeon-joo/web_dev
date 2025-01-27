package com.hae.has.common.model;

import com.hae.global.model.BaseVO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name="esaatth", schema = "emro")
public class Attach extends BaseVO implements Serializable{

    @Id
    @Column(name="sys_id", nullable = false, length = 18)
    private String sysId;
}
