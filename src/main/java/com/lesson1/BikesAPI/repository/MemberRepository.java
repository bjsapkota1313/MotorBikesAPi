package com.lesson1.BikesAPI.repository;

import com.lesson1.BikesAPI.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
     Optional<Member> findMemberByUsername(String username);

}
