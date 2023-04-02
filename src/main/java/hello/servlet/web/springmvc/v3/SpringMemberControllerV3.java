package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping(value = "/new-form", method = RequestMethod.GET) // 원래는 GET과 POST호출 모두 잘 나왔지만, method를 써줌으로써 GET 방식만 허용 !
    @GetMapping("/new-form") // 윗줄과 동일 !
    public String newForm() {
        return "new-form"; // 이렇게만 해주면 뷰 이름으로 알고 프로세스가 진행이 됨 !
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST) // 데이터 변경하는 것이기 때문에 GET으로 하면 문제 발생할 수도 !
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member); // 비즈니스 로직 해오고

        model.addAttribute("member", member); // 모델에 담고
        return "save-result"; // 뷰의 이름 반환

    }

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping()
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);

        return "members";
    }
}
