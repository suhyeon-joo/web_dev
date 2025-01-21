package com.hae.web.has.ils.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hae.web.has.ils.admin.model.IlsDept;

import java.util.List;
import java.util.Map;

@Repository
public interface IlsDeptRepository extends JpaRepository<IlsDept, Long> {

    List<IlsDept> findBySiteId(Long siteId);

    List<IlsDept> findBySiteIdAndIlsDeptNameContainingIgnoreCase(Long siteId, String ilsDeptName);

    IlsDept findBySiteIdAndIlsDeptId(Long siteId, Long ilsDeptId);
}
