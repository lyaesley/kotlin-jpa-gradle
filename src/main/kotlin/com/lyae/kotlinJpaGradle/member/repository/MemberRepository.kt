package com.lyae.kotlinJpaGradle.member.repository

import com.lyae.kotlinJpaGradle.member.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
    fun findByName(name: String) : Member?

    fun findAllByAge(age: Int) : List<Member>

}