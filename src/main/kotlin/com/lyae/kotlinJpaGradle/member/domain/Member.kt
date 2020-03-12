package com.lyae.kotlinJpaGradle.member.domain

import javax.persistence.*

@Entity
data class Member (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,

        @Column(nullable = false)
        var name: String = "",

        var age: Int = 0
)
{
        var coment: String = ""
}
