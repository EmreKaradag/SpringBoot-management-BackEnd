package com.temelt.issuemanagement.api;

import com.temelt.issuemanagement.dto.IssueDto;
import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.service.impl.IssueServiceImpl;
import com.temelt.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = ApiPaths.IssueCtrl.CTRL,description = "Issue APİs")
public class IssueController {

  private final IssueServiceImpl issueServiceImpl;

  public IssueController(IssueServiceImpl issueServiceImpl) {
    this.issueServiceImpl = issueServiceImpl;
  }


  @GetMapping("/{id}")
  @ApiOperation(value = "Get By Id Opreation" , response = IssueDto.class)
  public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id){
    IssueDto issueDto = issueServiceImpl.getById(id);
    return ResponseEntity.ok(issueDto);
  }

  @PostMapping
  @ApiOperation(value = "Create By Id Opreation" , response = IssueDto.class)
  public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issue){
    return  ResponseEntity.ok(issueServiceImpl.save(issue));

  }

  @PutMapping("/{id}")
  @ApiOperation(value = "Update By Id Opreation" , response = IssueDto.class)
  public ResponseEntity<IssueDto> updateProject(@PathVariable ("id") Long id ,@Valid @RequestBody IssueDto issue){

    return ResponseEntity.ok(issueServiceImpl.update(id,issue)) ;
  }


  @DeleteMapping("/{id}")
  @ApiOperation(value = "Delete By Id Opreation" , response = Boolean.class)
  public ResponseEntity<Boolean> delete(@PathVariable(value="id",required = true)Long id){

    return ResponseEntity.ok(issueServiceImpl.delete(id));
  }
}
