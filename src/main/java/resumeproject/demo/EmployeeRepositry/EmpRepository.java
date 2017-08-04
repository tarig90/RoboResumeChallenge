package resumeproject.demo.EmployeeRepositry;

import org.springframework.data.repository.CrudRepository;
import resumeproject.demo.modelzlayer.EmploymentData;

public interface EmpRepository extends CrudRepository<EmploymentData,Long> {
}
