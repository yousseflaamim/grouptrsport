package com.example.grupptransportmember.repositroy;

import com.example.grupptransportmember.modell.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
