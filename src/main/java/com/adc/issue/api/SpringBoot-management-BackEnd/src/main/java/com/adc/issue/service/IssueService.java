package com.adc.issue.service;

import com.adc.issue.dto.IssueDto;
import com.adc.issue.entity.Issue;
import com.adc.issue.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService  {

  IssueDto save(IssueDto issue); 

  IssueDto getById(Long id); 

  TPage<IssueDto> getAllPageable(Pageable pageable);

  Boolean delete(IssueDto issue);

}

