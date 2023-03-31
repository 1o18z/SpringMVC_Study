package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // 메시지 body의 내용을 바이트코드로 바로 얻을 수 있음 !

        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//  바이트를 문자로 바꿀 땐 항상 인코딩 정보 넘겨줘야 한다 !
        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
