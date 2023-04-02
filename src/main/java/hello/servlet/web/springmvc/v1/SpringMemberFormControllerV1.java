package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // (1) 이게 있으면 스프링이 자동으로 스프링 빈으로 등록
// (2) 스프링 MVC에서 어노테이션 기반 컨트롤러로 인식해서, RequestMapping에서 핸들러구나 하고 꺼낼 수 있는 대상이 됨 !
// @Controller 대신 @Component와 @RequestMapping 두 개를 써줘도 가능
// RequestMapping만 두고 스프링 빈에 직접 등록도 가능!
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    // 요청 정보를 매핑 : 해당 URL 호출되면 이 메서드 호출
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
