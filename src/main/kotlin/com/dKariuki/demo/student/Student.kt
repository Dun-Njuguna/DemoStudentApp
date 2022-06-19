package com.dKariuki.demo.student

import java.time.LocalDate
import java.time.Period
import javax.persistence.*

@Entity
@Table
data class Student(
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    var id: Int? = null,
    var name: String,
    var email: String,
    val dob: LocalDate,
    @Transient
    @JvmField
    val age: Int? = null
) {
    fun getAge(): Int? {
        return Period.between(dob, LocalDate.now()).years
    }


}