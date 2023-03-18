package hello.hello.service;

import hello.hello.repository.MemberRepository;
import hello.hello.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;

public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
