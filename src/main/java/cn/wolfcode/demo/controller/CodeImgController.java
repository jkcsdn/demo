package cn.wolfcode.demo.controller;

import com.ramostear.captcha.HappyCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CodeImgController {
    /**
     * 生成验证码
     * @param request
     * @param response
     */

    @RequestMapping("/codeImg")
    public void codeImg(HttpServletRequest request, HttpServletResponse response){
        HappyCaptcha.require(request,response).build().finish();
    }

}
