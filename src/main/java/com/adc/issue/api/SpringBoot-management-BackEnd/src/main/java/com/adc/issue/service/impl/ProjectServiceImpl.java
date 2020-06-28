package com.adc.issue.service.impl;

import com.adc.issue.entity.Project;
import com.adc.issue.repository.ProjectRepository;
import com.adc.issue.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

  private final ProjectRepository projectRepository;

  public ProjectServiceImpl(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }


  @Override
  public Project save(Project project) {

    if(project.getProjectCode()==null){
      throw new IllegalArgumentException("ProjectCode cannot be null!");
    }
    return projectRepository.save(project);
  }

  @Override
  public Project getById(Long id) {
    return projectRepository.getOne(id);
  }

  @Override
  public List<Project> getByProjectCode(String projectCode) {
    return null;
  }

  @Override
  public List<Project> getByProjectCodeContains(String projectCode) {
    return null;
  }

  @Override
  public Page<Project> getAllPageable(Pageable pageable) {
    return projectRepository.findAll(pageable);
  }

  @Override
  public Boolean delete(Project project) {
    /*projectRepository.delete(project);
    return Boolean.TRUE;*/
    return null;
  }
}
