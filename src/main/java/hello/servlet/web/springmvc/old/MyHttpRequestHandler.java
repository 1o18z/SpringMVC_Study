package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("/springmvc/request-handler") // (1) 핸들러 매핑으로 핸들러 조회 : 반 이름으로 핸들러 찾음! (BeanNameUrlHandlerMapping 실행 후 핸들러인 MyHttpRequestHandler 반환)
public class MyHttpRequestHandler implements HttpRequestHandler { // (2) 핸들러 어댑터 조회 : HandlerAdapter의 supports()를 순서대로 호출 (HttpRequestHandlerAdapter가 HttpRequestHandler 인터페이스를 지원하므로 대상이 됨)
    // (3) 핸들러 어댑터 실행 : HttpRequestHandlerAdapter는 핸들러인 MyHttpRequestHandler를 내부에서 실행하고, 그 결과 반환
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}
