package com.group.libraryapp.repository;

import com.group.libraryapp.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}

