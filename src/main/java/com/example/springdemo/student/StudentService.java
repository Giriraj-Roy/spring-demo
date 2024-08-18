package com.example.springdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email Already Taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentID){
        boolean exists = studentRepository.existsById(studentID);
        if(!exists){
            throw new IllegalStateException(
                    "Student with given id "+ studentID + " does not exist"
            );
        }
        studentRepository.deleteById(studentID);
    }
}
