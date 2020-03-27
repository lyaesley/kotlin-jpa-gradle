package com.lyae.kotlinJpaGradle.domain

import com.lyae.kotlinJpaGradle.repository.MemberRepository
import com.lyae.kotlinJpaGradle.repository.TeamRepository
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest @TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MemberRepositoryTest(@Autowired val memberRepository: MemberRepository,
                           @Autowired val teamRepository: TeamRepository,
                           @Autowired val testEntityManager: TestEntityManager)
{
    /*var junyoung = Member(
            name = "이준영",
            age = 34)

    var hyangju = Member(
            name = "박향주",
            age = 34)

    val team1 = Team(name = "Team1")
    val team2 = Team(name = "Team2")*/

    @BeforeAll
    fun initAll() {
//        junyoung.team = team1
//        hyangju.team = team2

//        teamRepository.save(team1)
//        teamRepository.save(team2)
//        memberRepository.save(junyoung)
//        memberRepository.save(hyangju)
    }

    @Test
    fun memberTest() {
        val junyoung = Member(
                name = "이준영",
                age = 34)

        val hyangju = Member(
                name = "박향주",
                age = 34)

        val nacho = Member(
                name = "나쵸",
                age = 20)

        val team1 = Team(name = "Team1")
        val team2 = Team(name = "Team2")

//        teamRepository.save(team1)
//        teamRepository.save(team2)
        testEntityManager.persist(team1)
        testEntityManager.persist(team2)


        junyoung.team = team1
        hyangju.team = team2
        nacho.team = team2

        hyangju.coment = "코멘트"

//        memberRepository.save(junyoung)
//        memberRepository.save(hyangju)
//        memberRepository.save(nacho)
        testEntityManager.persist(junyoung)
        testEntityManager.persist(hyangju)
        testEntityManager.persist(nacho)

        hyangju.coment = "save후변경" // memberRepository.save(hyangju) 후 memberRepository.findByName("박향주") 값 비교하기 위함

        println("향주 $hyangju")

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

        val findList = memberRepository.findByAge(34)
        println("findList.size = ${findList.size}")
        findList.forEach { member -> println("member 출력 $member") }
        assertEquals(junyoung, findList.firstOrNull { member-> member.name=="이준영" })
        assertEquals(hyangju, findList.firstOrNull { member-> member.name=="박향주" })

        testEntityManager.flush()
        testEntityManager.clear()

        val findTeamList = teamRepository.findAll()
        val findTeam2 = findTeamList.firstOrNull{ team -> team.name=="Team2"}
        println(findTeam2?.member)

        assertEquals(findHJ?.name, findTeam2?.member?.firstOrNull { member -> member.name=="박향주"}?.name)


    }
}