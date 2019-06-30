package com.adc.issue.service.impl;

import com.adc.issue.dto.IssueDto;
import com.adc.issue.entity.Issue;
import com.adc.issue.repository.IssueRepository;
import com.adc.issue.service.IssueService;
import com.adc.issue.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;


public class IssueServiceImpl implements IssueService {

 //imp save işlemini bu entitynin repositorysi üzerinden gerçeklleştirir. bu repositoryi inject etmemmız lazım
  // constructor injektion yapcaz. bir nesneye bir property e final etiketi verdiğiniz zaman bu nesnenın run time de değişmesini engellemiş baska birinin birşey atamasını engellemiş oluyoruz.
  // final bir nesneye atamayı sadece constructor içerisinde yapabiliyoruz


  private final IssueRepository issueRepository;
  private final ModelMapper modelMapper;

  public IssueServiceImpl(IssueRepository issueRepository,ModelMapper modelMapper) {
    this.issueRepository = issueRepository;
    this.modelMapper=modelMapper;
  }


  @Override
  public IssueDto save(IssueDto issue) {

    if(issue.getDate()==null)
      throw new IllegalArgumentException("issue date cannot be null");


   Issue issueDb= modelMapper.map(issue,Issue.class);
    issueDb=issueRepository.save(issueDb);
   return  modelMapper.map(issueDb,IssueDto.class);
   //önce dışardan gelen nesneyi(dto) içerdeki modele döndür. içerdeki modelden de veri tabnanına kaydettıkten sonra
    //o nesneyi yine dto ya dönüştürüp geri ver.

  }

  @Override
  public IssueDto getById(Long id) {
    return null;
  }

  @Override
  public TPage<IssueDto> getAllPageable(Pageable pageable) {
    Page<Issue> data = issueRepository.findAll(pageable);//pageble olarak bütün kayıtları Issueları çektim.Amacım dto ya dönüştürüp geri vermek.
    //Dönüşüm.Dönüşümü kendı response nesnemle yapıyorum TPage.
    TPage page=new TPage<IssueDto>();
   IssueDto[] dtos= modelMapper.map(data.getContent(),IssueDto[].class);
    page.setStat(data, Arrays.asList(dtos));
    return page;
  }

  @Override
  public Boolean delete(IssueDto issue) {
    return null;
  }
}
