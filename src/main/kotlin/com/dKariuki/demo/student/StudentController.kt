package com.dKariuki.demo.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/student")
class StudentController(
    @Autowired
    private val studentService: StudentService
) {

    @GetMapping
    fun getStudents()
            : List<Student> {
        return studentService.getStudents()
    }

    @PostMapping
    fun registerNewStudent(@RequestBody student: Student): Student {
        return studentService.registerNewStudent(student)
    }

    @PutMapping("/{studentId}")
    fun updateStudent(
        @PathVariable("studentId") studentId: Int,
        @RequestParam(required = false) name:String,
        @RequestParam(required = false) email:String
    ){
        studentService.updateStudent(studentId, name, email)
    }

    @DeleteMapping("/{studentId}")
    fun deleteStudent(@PathVariable studentId:Int){
        studentService.deleteService(studentId)
    }
}