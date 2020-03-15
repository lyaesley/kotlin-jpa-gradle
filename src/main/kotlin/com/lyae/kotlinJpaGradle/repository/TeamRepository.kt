package com.lyae.kotlinJpaGradle.repository

import com.lyae.kotlinJpaGradle.domain.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository: JpaRepository<Team, Long> {
}