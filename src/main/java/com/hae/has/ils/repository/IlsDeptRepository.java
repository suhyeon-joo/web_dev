package com.hae.has.ils.repository;

import com.hae.has.ils.model.IlsDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IlsDeptRepository extends JpaRepository<IlsDept, Long> {

    List<IlsDept> findBySiteId(Long siteId);

    List<IlsDept> findBySiteIdAndIlsDeptNameContainingIgnoreCase(Long siteId, String ilsDeptName);

    IlsDept findBySiteIdAndIlsDeptId(Long siteId, Long ilsDeptId);
}
