package com.adc.issue.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id ;


  @Column(name = "uname",length = 100,unique = true)
  private String username;

  @Column(name = "pwd",length = 200)
  private String password;


  @Column(name = "name_surname",length = 200)
  private String nameSurname;


  @Column(name = "email",length = 100)
  private String email;

  @JoinColumn(name = "assignee_user_id")
  @OneToMany(fetch = FetchType.LAZY)
  private List<Issue> issues;

  //olurda ihtiyaç duyarsam. bu kullanıcıyı select ettiğimde bu kulanıcıya ait issue ları görmek istiyor olursam diye
  // buna lazy sekilde oneToMany dedim
  // bir tane kullanıcıya birçok issue baglanabilir. onları çekmek istedğimdede List çagırıcam



}
