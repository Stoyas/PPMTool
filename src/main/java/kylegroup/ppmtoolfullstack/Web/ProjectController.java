package kylegroup.ppmtoolfullstack.Web;

import kylegroup.ppmtoolfullstack.Domain.Project;
import kylegroup.ppmtoolfullstack.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService service;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        HashMap<String, String> errorMap = new HashMap<String, String>();
        for(FieldError error: result.getFieldErrors()){
            errorMap.put(error.getField(), error.getDefaultMessage());
        }
        if(result.hasErrors()){
            return new ResponseEntity<HashMap<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Project project1 = service.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
}
