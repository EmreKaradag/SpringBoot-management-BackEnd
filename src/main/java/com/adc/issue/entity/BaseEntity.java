package com.adc.issue.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.temporal.TemporalAmount;
import java.util.Date;

@Data
@MappedSuperclass

public class BaseEntity implements Serializable {

  @Column(name = "created_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createAt;

  @Column(name ="created_by",length = 50)
  private String createdBy;

  @Column(name = "updated_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @Column(name = "updated_by",length = 50)
  private String updatedBy;

  @Column(name = "status")
  private Boolean status; 

}
