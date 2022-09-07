package amirscode.company.service;

import amirscode.company.entity.Company;
import amirscode.company.entity.Department;
import amirscode.company.model.ApiResponse;
import amirscode.company.model.DepartmentDTO;
import amirscode.company.repository.CompanyRepository;
import amirscode.company.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department get(Integer id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        return optionalDepartment.get();
    }

    public ApiResponse add(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());

        Optional<Company> optionalCompany = companyRepository.findById(departmentDTO.getCompId());
        Company company = optionalCompany.get();
        department.setCompany(company);
        departmentRepository.save(department);

        return new ApiResponse("added", true);
    }

    public ApiResponse edit(Integer id, DepartmentDTO departmentDTO) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        Department department = optionalDepartment.get();
        department.setName(departmentDTO.getName());

        Optional<Company> optionalCompany = companyRepository.findById(departmentDTO.getCompId());
        Company company = optionalCompany.get();
        department.setCompany(company);
        departmentRepository.save(department);

        return new ApiResponse("edited", true);
    }

    public ApiResponse delete(Integer id){
        departmentRepository.deleteById(id);
        return new ApiResponse("deleted", true);
    }

}
