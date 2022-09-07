package amirscode.company.controller;

import amirscode.company.model.CompanyDTO;
import amirscode.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.get(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> add(@PathVariable Integer id, @RequestBody CompanyDTO companyDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.add(id, companyDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, Integer addressId, @RequestBody CompanyDTO companyDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.edit(id, addressId, companyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.delete(id));
    }
}
