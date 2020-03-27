package com.lyae.kotlinJpaGradle.repository

import com.lyae.kotlinJpaGradle.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
    fun findByName(name: String) : Member?

    fun findByAge(age: Int) : List<Member>

}