package com.adc.issue.repository;

import com.adc.issue.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project,Long> {

  List<Project> getAllByProjectCode(String projectCode);

  List<Project>getAllByProjectCodeAndIdNotNull(String projectCode);
 

  List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode,String name);


  Page<Project> findAll(Pageable pageable);

  List<Project> findAll(Sort sort);
}
