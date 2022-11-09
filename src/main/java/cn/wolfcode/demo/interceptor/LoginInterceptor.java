package cn.wolfcode.demo.interceptor;

import cn.wolfcode.demo.exception.MyException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session作用域
        HttpSession session = request.getSession();
        //获取User
        Object user = session.getAttribute("user");
        if(user!=null){
            return true;
        }else{
            throw new MyException("用户未登录，请先登录");
        }
    }
}
