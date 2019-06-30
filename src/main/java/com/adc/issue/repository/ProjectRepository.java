package com.adc.issue.repository;

import com.adc.issue.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project,Long> {

  List<Project> getAllByProjectCode(String projectCode);
  //Ben project codunu vereyim oda bana projectCode ile eşleşen bütün kayıtları getirsin
//string kısmına direk property ismini yazıyoruz
  //veritabanında bir select işlemi yapmış oluyoruz

  List<Project>getAllByProjectCodeAndIdNotNull(String projectCode);
  //Id si null olmayacak ve ProjectCode da projectCode olan kayıtlar gelsın


  List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode,String name);

//bu repositoryleri singelten instance olarak kullanacaz uygulamamızda


  Page<Project> findAll(Pageable pageable);

  List<Project> findAll(Sort sort);
}
