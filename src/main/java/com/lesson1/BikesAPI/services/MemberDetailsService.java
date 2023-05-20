package com.lesson1.BikesAPI.services;

import com.lesson1.BikesAPI.model.Member;
import com.lesson1.BikesAPI.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public MemberDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Member member = memberRepository.findMemberByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User '" + username + "' not found"));

        return User
                .withUsername(username)
                .password(member.getPassword())
                .authorities(member.getRoles())
                .build();
    }
}
