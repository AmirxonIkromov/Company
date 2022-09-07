package amirscode.company.controller;

import amirscode.company.model.DepartmentDTO;
import amirscode.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.get(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody DepartmentDTO departmentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.add(departmentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody DepartmentDTO departmentDTO){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.edit(id,departmentDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.delete(id));
    }
}
