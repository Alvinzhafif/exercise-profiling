package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Course;
import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {
        List<Student> students = studentRepository.findAll();
        List<StudentCourse> studentCourses = new ArrayList<>();

        Map<Long, List<Course>> studentCoursesMap = new HashMap<>();

        List<StudentCourse> allStudentCourses = studentCourseRepository.findAll();

        for (StudentCourse studentCourse : allStudentCourses) {
            Long studentId = studentCourse.getStudent().getId();
            if (!studentCoursesMap.containsKey(studentId)) {
                studentCoursesMap.put(studentId, new ArrayList<>());
            }
            studentCoursesMap.get(studentId).add(studentCourse.getCourse());
        }

        for (Student student : students) {
            List<Course> courses = studentCoursesMap.getOrDefault(student.getId(), Collections.emptyList());
            for (Course course : courses) {
                StudentCourse studentCourse = new StudentCourse();
                studentCourse.setStudent(student);
                studentCourse.setCourse(course);
                studentCourses.add(studentCourse);
            }
        }

        return studentCourses;
    }


    public Optional<Student> findStudentWithHighestGpa() {
        return studentRepository.findAll().stream()
                .max(Comparator.comparingDouble(Student::getGpa));
    }

    public String joinStudentNames() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }

}

