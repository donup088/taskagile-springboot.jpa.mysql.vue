package com.taskagile.repository;

import com.taskagile.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);

    Member findByEmail(String email);
}
