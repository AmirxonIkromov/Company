package amirscode.company.service;

import amirscode.company.entity.Address;
import amirscode.company.entity.Department;
import amirscode.company.entity.Worker;
import amirscode.company.model.ApiResponse;
import amirscode.company.model.WorkerDTO;
import amirscode.company.repository.AddressRepository;
import amirscode.company.repository.DepartmentRepository;
import amirscode.company.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Worker> getAll() {
        return workerRepository.findAll();

    }

    public Worker get(Integer id) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        return optionalWorker.get();
    }

    public ApiResponse add(WorkerDTO workerDTO) {
        Worker worker = new Worker();
        worker.setName(workerDTO.getName());
        worker.setPhoneNumber(workerDTO.getPhoneNumber());

        Optional<Address> optionalAddress = addressRepository.findById(workerDTO.getAddressId());
        Address address = optionalAddress.get();
        worker.setAddress(address);

        Optional<Department> optionalDepartment = departmentRepository.findById(workerDTO.getDepartmentId());
        Department department = optionalDepartment.get();
        worker.setDepartment(department);
        workerRepository.save(worker);
        return new ApiResponse("added", true);
    }

    public ApiResponse edit(Integer id, WorkerDTO workerDTO){
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        Worker worker = optionalWorker.get();
        worker.setPhoneNumber(workerDTO.getPhoneNumber());
        worker.setName(workerDTO.getName());

        Optional<Address> optionalAddress = addressRepository.findById(workerDTO.getAddressId());
        Address address = optionalAddress.get();
        worker.setAddress(address);

        Optional<Department> optionalDepartment = departmentRepository.findById(workerDTO.getDepartmentId());
        Department department = optionalDepartment.get();
        worker.setDepartment(department);
        workerRepository.save(worker);
        return new ApiResponse("added", true);
    }

    public ApiResponse delete(Integer id){
        workerRepository.deleteById(id);
        return new ApiResponse("deleted", true);
    }

}
