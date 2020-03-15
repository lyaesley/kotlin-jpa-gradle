package com.lyae.kotlinJpaGradle.domain

import javax.persistence.*

@Entity
class Team (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,

        var name: String = "",

        @OneToMany(mappedBy = "team")
        var member: MutableList<Member> = mutableListOf()
)