package amirscode.company.controller;

import amirscode.company.model.WorkerDTO;
import amirscode.company.repository.WorkerRepository;
import amirscode.company.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    WorkerService workerService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(workerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(workerService.get(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody WorkerDTO workerDTO){
        return ResponseEntity.status(HttpStatus.OK).body(workerService.add(workerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, WorkerDTO workerDTO){
        return ResponseEntity.status(HttpStatus.OK).body(workerService.edit(id,workerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(workerService.delete(id));
    }

}
