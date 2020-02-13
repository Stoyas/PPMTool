package kylegroup.ppmtoolfullstack.Service;

import kylegroup.ppmtoolfullstack.Domain.Project;
import kylegroup.ppmtoolfullstack.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository repository;

    public Project saveOrUpdateProject(Project project){
        return repository.save(project);
    }
}
