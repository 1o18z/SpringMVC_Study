package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance(); // 싱글톤이라 new 안됨!!

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
        // 순서가 보장이 안되기 때문에 꼭 clearStore 해줘야 함 !
        // (save가 먼저 실행되고 findAll이 실행된다면 이미 save에서 저장된 member 때문에 사이즈가 3이 나와버림)

    }

    @Test
    void save(){
        // given
        Member member = new Member("hello", 20);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        // given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 21);

        memberRepository.save(member1);
        memberRepository.save(member2);
        // when

        List<Member> result = memberRepository.findAll();

        // then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1, member2);


    }


}
