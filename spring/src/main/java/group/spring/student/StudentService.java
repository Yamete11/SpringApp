package group.spring.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        boolean exists = studentRepository.findByName(student);

        if(exists){
            throw new IllegalStateException("Student with provided name already exists");
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        boolean exists = studentRepository.existsById(id);

        if(exists){
            throw new IllegalStateException("Student doesn't exist");
        }

        studentRepository.deleteById(id);
    }
}
