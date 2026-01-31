package com.example.imran.Library.Management.System.repository;

import com.example.imran.Library.Management.System.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberByMembershipId(String membershipId);
}
