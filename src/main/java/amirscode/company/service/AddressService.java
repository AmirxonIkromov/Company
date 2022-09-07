package amirscode.company.service;

import amirscode.company.entity.Address;
import amirscode.company.model.AddressDTO;
import amirscode.company.model.ApiResponse;
import amirscode.company.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address get(Integer id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        return optionalAddress.get();
    }

    public ApiResponse add(AddressDTO addressDTO) {
        Address address = new Address();
        address.setStreet(addressDTO.getStreet());
        address.setHomeNumber(addressDTO.getHomeNumber());
        addressRepository.save(address);
        return new ApiResponse("added", true);
    }

    public ApiResponse edit(Integer id, AddressDTO addressDTO) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        Address address = optionalAddress.get();
        address.setHomeNumber(addressDTO.getHomeNumber());
        address.setStreet(addressDTO.getStreet());
        addressRepository.save(address);

        return new ApiResponse("edited", true);
    }

    public ApiResponse delete(Integer id) {
        addressRepository.deleteById(id);
        return new ApiResponse("deleted", true);
    }
}
