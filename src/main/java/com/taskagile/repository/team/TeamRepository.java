package com.taskagile.repository.team;

import com.taskagile.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> ,TeamCustomRepository{
}
