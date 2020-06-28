package com.adc.issue.dto;

import com.adc.issue.entity.IssueStatus;
import com.adc.issue.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class IssueDto {
  private Long id;

  private String description;

  private String details;

  private Date date;

  private IssueStatus issueStatus;

  private UserDto assignee;

  private ProjectDto project;


}
