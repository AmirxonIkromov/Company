package amirscode.company.service;

import amirscode.company.entity.Address;
import amirscode.company.entity.Company;
import amirscode.company.model.ApiResponse;
import amirscode.company.model.CompanyDTO;
import amirscode.company.repository.AddressRepository;
import amirscode.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressRepository addressRepository;

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company get(Integer id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        return optionalCompany.get();
    }

    public ApiResponse add(Integer id, CompanyDTO companyDTO) {
        Company company = new Company();
        company.setCorpName(companyDTO.getCorpName());
        company.setDirectorName(companyDTO.getDirectorName());

        Optional<Address> optionalAddress = addressRepository.findById(id);
        Address address = optionalAddress.get();
        company.setAddress(address);
        companyRepository.save(company);

        return new ApiResponse("added", true);
    }

    public ApiResponse edit(Integer id, Integer addressId, CompanyDTO companyDTO) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        Company company = optionalCompany.get();
        company.setDirectorName(companyDTO.getDirectorName());
        company.setCorpName(companyDTO.getCorpName());

        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        Address address = optionalAddress.get();
        address.setStreet(companyDTO.getStreet());
        address.setHomeNumber(companyDTO.getHomeNumber());
        company.setAddress(address);
        companyRepository.save(company);

        return new ApiResponse("edited", true);
    }

    public ApiResponse delete(Integer id) {
        companyRepository.deleteById(id);
        return new ApiResponse("deleted", true);
    }

}
