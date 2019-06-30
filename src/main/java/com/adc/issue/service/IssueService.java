package com.adc.issue.service;

import com.adc.issue.dto.IssueDto;
import com.adc.issue.entity.Issue;
import com.adc.issue.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService  {

  IssueDto save(IssueDto issue); //issue kaydını parametre aldı metodum. o kaydettiği kaydın son halini geri döndü

  IssueDto getById(Long id); // bi id vercem metoda oda bana o id li kaydı döndürecek

  TPage<IssueDto> getAllPageable(Pageable pageable); // 10. sayfadakı 10 kaydı dönder gib.

  Boolean delete(IssueDto issue);

}

