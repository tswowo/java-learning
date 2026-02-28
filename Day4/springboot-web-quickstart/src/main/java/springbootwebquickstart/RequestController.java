package springbootwebquickstart;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        //获取请求方式
        System.out.println("请求方式：" + request.getMethod());
        //获取请求地址url
        System.out.println("请求地址：" + request.getRequestURL());
        //获取请求协议
        System.out.println("请求协议：" + request.getProtocol());
        //获取请求参数
        System.out.println("请求参数：" + request.getParameter("username"));
        //获取请求头 - Accept
        System.out.println("请求头 - Accept：" + request.getHeader("Accept"));


        return "请求方式：" + request.getMethod() + "<br/>" +
                "请求地址：" + request.getRequestURL() + "<br/>" +
                "请求协议：" + request.getProtocol() + "<br/>" +
                "请求参数：" + request.getParameter("username") + "<br/>" +
                "请求头 - Accept：" + request.getHeader("Accept");
    }
}
