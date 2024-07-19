package uni_campus.uni_campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni_campus.uni_campus.model.University;
import uni_campus.uni_campus.service.UniversityService;

import java.util.List;
import java.util.Optional;

/** @noinspection ALL*/
@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<University> getUniversityById(@PathVariable int id) {
        Optional<University> university = universityService.getUniversityById(id);
        return university.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public University createUniversity(@RequestBody University university) {
        return universityService.createUniversity(university);
    }

    @PutMapping("/{id}")
    public ResponseEntity<University> updateUniversity(@PathVariable int id, @RequestBody University university) {
        University updatedUniversity = universityService.updateUniversity(id, university);
        if (updatedUniversity != null) {
            return ResponseEntity.ok(updatedUniversity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable int id) {
        boolean isDeleted = universityService.deleteUniversity(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
