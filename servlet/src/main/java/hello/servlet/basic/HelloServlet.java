package hello.servlet.basic;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    // HttpServletRequest,HttpServletResponse 둘 다 인터페이스
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 서비스 메서드 호출 (ctrl + O 에서 service 치고 자물쇠 있는 거)
        // 톰켓이나 제티, 언더독? 등등 여러가지 was 서버가 서블릿 표준 스펙을 구현하는 것
        //request = org.apache.catalina.connector.RequestFacade@744c8833
        //response = org.apache.catalina.connector.ResponseFacade@1fcb5eda
        // 위처럼 구현체가 찍히는 것
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        //getParameter 로 쿼리 파라미터 조회 가능
        //http://localhost:8080/hello/username=kim
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //위 두개는 컨텐트 타입으로 header에 들어가는 정보
        response.getWriter().write("hello" + username);
        // 개발자도구 함 봐바
        //WebServlet 의 name 과 urlPatterns 겹치면 안됨.
    }
}
