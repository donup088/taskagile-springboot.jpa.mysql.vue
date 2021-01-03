package com.taskagile.repository.team;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.taskagile.domain.*;

import javax.persistence.EntityManager;
import java.util.List;

import static com.taskagile.domain.QMember.*;
import static com.taskagile.domain.QMemberTeam.*;
import static com.taskagile.domain.QTeam.*;

public class TeamRepositoryImpl implements TeamCustomRepository {
    private JPAQueryFactory queryFactory;

    public TeamRepositoryImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Team> getTeamByMember(Member curMember) {
        return queryFactory
                .select(team)
                .from(team)
                .join(team.memberTeam,memberTeam)
                .where(memberTeam.member.id.eq(curMember.getId()))
                .fetch();

    }
}
