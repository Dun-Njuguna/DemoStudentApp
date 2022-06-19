package com.dKariuki.demo.student

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface StudentRepository:JpaRepository<Student, Int>{

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    fun findStudentByEmail(email:String):Optional<Student>

}