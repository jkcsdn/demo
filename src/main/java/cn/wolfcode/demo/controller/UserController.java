package cn.wolfcode.demo.controller;

import cn.wolfcode.demo.entiy.ResponseBean;
import cn.wolfcode.demo.entiy.User;
import cn.wolfcode.demo.service.UserService;
import com.ramostear.captcha.HappyCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

//@CrossOrigin(value = "http://localhost:8080",allowCredentials = "true") //跨域注解(当前文件)
@Controller
@Slf4j
public class UserController {
    /**
     *实现登录
     * @param user 账号和密码
     * @return success
     */
    @Autowired
    UserService userService;

    @Value("${upload.imgurl}")
    private String imgUrl;
    @Value("${upload.imgweb}")
    private String imgWeb;

    /**
     * 实现登录
     * @param user 账号和密码
     * @return success
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResponseBean login(@RequestBody User user, HttpServletRequest request) {
        //1.校验验证码是否正确
        boolean verification = HappyCaptcha.verification(request, user.getCode(), true);
        if (!verification) {
//            return "验证码错误";
            //返回响应Bean
            return new ResponseBean(500, "验证码错误", null);
        }
        //开始验证用户名和密码
        //查询数据
        User userResult = userService.login(user);
        //判断是否为空
        if (userResult != null) {
            //存在
            request.getSession().setAttribute("user",userResult);
            // return "登录成功";
            //返回响应Bean
            return new ResponseBean(200, "登录成功", userResult);
        } else {
            //return "用户名或密码错误";
            //返回响应Bean
            return new ResponseBean(500, "用户名或密码错误", null);
        }
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public ResponseBean updateUser(@RequestBody User user){
        //调用service
        int row = userService.update(user);
        if(row>0)
            return new ResponseBean(200,"修改用户信息成功",null);
        else {
            return new ResponseBean(500,"修改用户信息失败",null);
        }
    }


    /**
     *获取element-ui和file
     * multipartFile.文件
     * @return success
     */
    @RequestMapping("/uploadUserImg")
    @ResponseBody
    public ResponseBean uploadUserImg(@RequestParam("file") MultipartFile multipartFile,User user){
        //获取文件名
        String originalFilename = multipartFile.getOriginalFilename();
        //控制台打印信息
        log.info("上传头像："+originalFilename);
        //随机生成一个文件名
        String uuid = UUID.randomUUID().toString().replace("-","");
        //获取图片扩展名
        String extension = FilenameUtils.getExtension(originalFilename);
        //获取新的文件名
        String newFileName = uuid + "." +extension;
        //声明放置头像的目录
        File directory = new File(imgUrl + "user");
        //判断目录是否存在，如果不存在生成该目录
        if(!directory.exists()){
            directory.mkdir();
        }
        try {
            //开始存放
            multipartFile.transferTo(new File(directory,newFileName));
            //删除原本照片
            String headImgUrl = user.getHeadImg().replace(imgWeb,imgUrl);
            //删除照片
            File file = new File(headImgUrl);
            file.delete();
            //打印日志
            log.info("原本存放图片路径" + headImgUrl);
            //新的图片的网络路径
            String path = imgWeb + "user/" + newFileName;
            return new ResponseBean(200,"上传头像成功",path);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseBean(500,"上传头像失败",null);
        }

    }
}
