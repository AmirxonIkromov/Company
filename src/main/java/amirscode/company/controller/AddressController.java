package amirscode.company.controller;

import amirscode.company.entity.Address;
import amirscode.company.model.AddressDTO;
import amirscode.company.model.ApiResponse;
import amirscode.company.repository.AddressRepository;
import amirscode.company.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Address> addressList = addressService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(addressList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        Address address = addressService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody AddressDTO addressDTO) {
        ApiResponse apiResponse = addressService.add(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @Valid @RequestBody AddressDTO addressDTO) {
        ApiResponse apiResponse = addressService.edit(id, addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = addressService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
