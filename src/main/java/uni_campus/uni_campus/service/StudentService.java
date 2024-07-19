package uni_campus.uni_campus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni_campus.uni_campus.model.Student;
import uni_campus.uni_campus.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

/** @noinspection ALL*/
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        } else {
            return null;
        }
    }

    public boolean deleteStudent(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
