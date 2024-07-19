package uni_campus.uni_campus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni_campus.uni_campus.model.University;
import uni_campus.uni_campus.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

/** @noinspection ALL*/
@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    public Optional<University> getUniversityById(int id) {
        return universityRepository.findById(id);
    }

    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    public University updateUniversity(int id, University university) {
        if (universityRepository.existsById(id)) {
            university.setId(id);
            return universityRepository.save(university);
        } else {
            return null;
        }
    }

    public boolean deleteUniversity(int id) {
        if (universityRepository.existsById(id)) {
            universityRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
