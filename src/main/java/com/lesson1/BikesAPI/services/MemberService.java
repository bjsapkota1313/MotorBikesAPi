package com.lesson1.BikesAPI.services;

import com.lesson1.BikesAPI.jwt.JwtTokenProvider;
import com.lesson1.BikesAPI.model.APIExceptions.ConflictException;
import com.lesson1.BikesAPI.model.DTO.CreateUserDTO;
import com.lesson1.BikesAPI.model.DTO.LoginRequestDTO;
import com.lesson1.BikesAPI.model.Member;
import com.lesson1.BikesAPI.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public MemberService(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    public Member addMember(CreateUserDTO member){
        if(memberRepository.findMemberByUsername(member.username()).isPresent()){
            throw new ConflictException("Username already exists");
        }
        return memberRepository.save(new Member(member.username(), bCryptPasswordEncoder.encode(member.password()),
                List.of(member.role())));
    }
    public String login (LoginRequestDTO loginRequestDTO) throws AuthenticationException {
        Member member = memberRepository.findMemberByUsername(loginRequestDTO.username()).orElseThrow(() ->
                new AuthenticationException("Username does not exist"));
        if(bCryptPasswordEncoder.matches(loginRequestDTO.password(), member.getPassword())){
            return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
        }
        throw new AuthenticationException("Password is incorrect") ;
    }
}
