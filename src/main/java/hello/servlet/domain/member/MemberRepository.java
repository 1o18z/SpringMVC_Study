package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConsurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 사실 싱글톤이라 static 없어도 됨! (하나인 게 보장이 되니까)
    private static long sequence = 0L; //  id 하나씩 증가하는 거

    private static final MemberRepository instance = new MemberRepository();
    // 싱글톤으로

    public static MemberRepository getInstance(){
        return instance;
    } // 싱글톤이라 무조건 이거로 조회해야 함 !

    private MemberRepository(){}

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    } // store 자체를 보호하기 위함 ! (store의 value를 건들지 않으려고) -> 물론 직접 가져와서 수정하면 수정은 됨 !

    public void clearStore(){
        store.clear();
    }

}
