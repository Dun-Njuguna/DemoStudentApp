package com.dKariuki.demo.student

import com.dKariuki.demo.exception.RecordNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Objects
import java.util.Optional
import javax.transaction.Transactional

@Service
class StudentService(
    @Autowired
    private val studentRepository: StudentRepository
)  {
    fun getStudents()
            : List<Student> {
        return studentRepository.findAll()
    }

    fun registerNewStudent(student: Student): Student {
        val studentByEmail:Optional<Student> = studentRepository.findStudentByEmail(student.email)
        if (studentByEmail.isPresent){
            throw RecordNotFoundException("Email already exists")
        }
        return studentRepository.save(student)
    }

    fun deleteService(studentId: Int) {
       val exists =  studentRepository.existsById(studentId)
        if (!exists){
            throw RecordNotFoundException("Student id:- $studentId does not exist")
        }
        studentRepository.deleteById(studentId)
    }

    @Transactional
    fun updateStudent(studentId: Int, name: String?, email: String?) {
        val student = studentRepository.findById(studentId)
            .orElseThrow { RecordNotFoundException("Student id:- $studentId does not exist") }

        name?.let {
            if (name.isNotEmpty() && !Objects.equals(student.name, name)){
                student.name = name
            }
        }

        email?.let {
            if (email.isNotEmpty() && !Objects.equals(student.email, email)) {
                val studentOptional = studentRepository.findStudentByEmail(email)
                if (studentOptional.isPresent) {
                    throw RecordNotFoundException("Email already exists")
                }
                student.email = email
            }
        }
    }

}