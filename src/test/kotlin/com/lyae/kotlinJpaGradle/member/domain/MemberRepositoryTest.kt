package com.lyae.kotlinJpaGradle.member.domain

import com.lyae.kotlinJpaGradle.member.repository.MemberRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class MemberRepositoryTest(@Autowired val memberRepository: MemberRepository)
{

    @Test
    fun memberTest() {
        val junyoung = Member(
                name = "이준영",
                age = 34)

        val hyangju = Member(
                name = "박향주",
                age = 34)

        println("향주1 $hyangju")
        hyangju.coment = "코멘트"
        println("향주2 $hyangju")
        memberRepository.save(junyoung)
        memberRepository.save(hyangju)

        hyangju.coment = "save후변경"

        println("저장 개수 = ${memberRepository.findAll().size}")
        val findJY: Member? = memberRepository.findByName("이준영")
        val findHJ: Member? = memberRepository.findByName("박향주")

        println("memberRepository.findByName(\"이준영\") = $findJY")
        println("memberRepository.findByName(\"박향주\") = $findHJ")

        assertEquals("이준영", findJY?.name)
        assertEquals(34, findJY?.age)

        assertEquals("박향주", findHJ?.name)
        assertEquals(34, findHJ?.age)
        assertEquals("save후변경", findHJ?.coment)
        assertNotEquals("코멘트", findHJ?.coment)

        assertEquals(junyoung, findJY)

        val findList = memberRepository.findAllByAge(34)
        println("findList.size = ${findList.size}")
        findList.forEach { member -> println("member 출력 $member") }
        assertEquals(junyoung, findList.firstOrNull { member-> member.name=="이준영" })
        assertEquals(hyangju, findList.firstOrNull { member-> member.name=="박향주" })

    }
}