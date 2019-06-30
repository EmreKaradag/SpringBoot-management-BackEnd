package com.adc.issue.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity{

  @Id//PrimaryKey
  @GeneratedValue(strategy = GenerationType.AUTO)//Sistem tarafından oto olusturmasını saglıyoruz.id nin oto artması
  private Long id;

  @Column(name = "description",length = 1000)
  private String description;

  @Column(name = "details",length = 4000)
  private String details;

  @Column(name = "date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  @Column(name = "issue_status")
  @Enumerated(EnumType.STRING) //veritabanında bu verinin nasıl durmasını ıstıyorsunuz
  private IssueStatus issueStatus;

  @JoinColumn(name = "assignee_user_id")
  @ManyToOne(optional = true,fetch = FetchType.LAZY)
  private User assignee;

  @JoinColumn(name = "project_id")
  @ManyToOne(optional = true,fetch = FetchType.LAZY)
  private Project project;

  //ıssue  assignee manytoone ile bi join işlemi yaptık. Bir tablodan diğer tabloya
  //bi relation tanımı yapıyorsak ilgili prop içinde veya  ilgili tablolar birbiri içerisinde ilişki tipine göre prop olarak yaratılır
  //many ilk etiket yani birçok issue class ı birtane user baglanabilir
  //biri optional true yani bi issue nesnesi yaratırken bunun assignee yani bir kullanıcıya atamasanda olur
  //fetch ise , burada bu issue tablosuna select atılırken. User tablosundaki ilişkili tablosuna join yapıp getirilsinmi
  //lazy bu methodun sadece getter çagırıldıgında yanı sadece ıhtiyac oldugunda cagırılır
  //eager veritabanına yük getirir.performans kaybı olur.


  //ZOrunlı olan 2 durum var .1 si PrimaryKey. 2.si Entity annotationu

}
