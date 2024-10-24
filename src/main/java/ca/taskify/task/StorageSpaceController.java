package ca.taskify.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/spaces")
public class StorageSpaceController {
    @Autowired
    private StorageSpaceRepository repository;

    @GetMapping
    public ResponseEntity<List<StorageSpace>> getAllSpaces() {
        return new ResponseEntity<List<StorageSpace>>(repository.findAll(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<StorageSpace> getSpaceById(@PathVariable String id) {
//        Optional<StorageSpace> space = repository.findById(id);
//        return space.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
}
