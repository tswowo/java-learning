package springbootwebquickstart;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    @RequestMapping("/response1")
    public void response1(HttpServletResponse response) throws IOException {
        //设置响应状态码
        //response.setStatus(200);
        response.setStatus(HttpServletResponse.SC_OK);
        //设置响应头
        response.setHeader("Access-Control-Allow-Origin", "*");
        //设置响应体
        response.getWriter().write("<h1>Hello Response1</h1>");
    }

    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity.status(HttpServletResponse.SC_OK).header("name", "JavaWeb")
                .body("<h1>Hello Response2</h1>");
    }
}
