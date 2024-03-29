package com.lyae.kotlinJpaGradle.domain

import javax.persistence.*

@Entity
data class Member (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,

        @Column(nullable = false)
        var name: String = "",

        @Column(nullable = true)
        var age: Int = 0,

        @Column(nullable = true)
        var coment: String = "",

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="Team_id")
        var team: Team? = null


)
{
        //@Column(nullable = true)
        //var coment: String = ""
        //toString()은 생성자에 정의된 프로퍼티만 출력하고,
        // 클래스 내에 지역변수로 선언한 프로퍼티는 출력하지 않습니다.
        // 지역변수도 toString()에 출력하고 싶으면 직접 오버라이드해서 구현해줘야 합니다.

}
