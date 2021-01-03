package com.taskagile.repository;

import com.taskagile.domain.MemberTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTeamRepository extends JpaRepository<MemberTeam, Long> {
}
