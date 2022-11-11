package group.spring.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent = studentService.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
