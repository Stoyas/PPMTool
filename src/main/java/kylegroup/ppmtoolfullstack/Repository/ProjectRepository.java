package kylegroup.ppmtoolfullstack.Repository;

import kylegroup.ppmtoolfullstack.Domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
