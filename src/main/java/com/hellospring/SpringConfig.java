package com.hellospring;

import com.hellospring.aop.TimeTraceAop;
import com.hellospring.repository.*;
import com.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 자바코드로 직접 스프링 빈 등록하는 방법
 */
@Configuration
public class SpringConfig {

    /*Jdbc를 사용할때는 DataSource 사용
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    /*jpa 를 사용할때는 EntityManager을 사용
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */

    /* SpringDataJpa를 사용*/
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);          //Jdbc를 이용
//        return new JdbcTemplateMemberRepository(dataSource);    //jdbcTemplate을 이용
//        return new JpaMemberRepository(em);
//    }
}
