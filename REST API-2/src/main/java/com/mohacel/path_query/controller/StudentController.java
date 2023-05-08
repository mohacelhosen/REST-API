package com.mohacel.path_query.controller;

import com.mohacel.path_query.model.Product;
import com.mohacel.path_query.model.Student;
import com.mohacel.path_query.model.StudentInterest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1002,"Mohacel", "CSE",new StudentInterest("Football","Java","Academic"));
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1002, "Mohacel", "CSE",new StudentInterest("Football","Java","Academic")));
        studentList.add(new Student(1003, "Adi", "CSE",new StudentInterest("COD","Python","Academic")));
        studentList.add(new Student(1004, "Reznu", "CSE",new StudentInterest("Football","CPP","Academic")));

        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

}
