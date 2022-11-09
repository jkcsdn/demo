package cn.wolfcode.demo.controller;

import cn.wolfcode.demo.entiy.ResponseBean;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class UploadImageController {
    @Value("${upload.imgurl}")
    private String imgUrl;
    @Value("${upload.imgweb}")
    private String imgWeb;

    @RequestMapping("/uploadImage")
    @ResponseBody
    public ResponseBean uploadUserImg(@RequestParam("file") MultipartFile multipartFile, String folder){
//          //获取文件名
//        String originalFilename = multipartFile.getOriginalFilename();
//        //随机生成一个文件名
//        String uuid = UUID.randomUUID().toString().replace("-","");
//        //获取图片扩展名
//        String extension = FilenameUtils.getExtension(originalFilename);
//        //获取新的文件名
//        String newFileName = uuid + "." +extension;
//        //声明放置头像的目录
//        File directory = new File(imgUrl + folder);
//        //判断目录是否存在，如果不存在生成该目录
//        if(!directory.exists()){
//            directory.mkdir();
//        }
//        try {
//            //开始存放
//            multipartFile.transferTo(new File(directory,newFileName));
//            //新的图片的网络路径
//            String path = imgWeb + folder + newFileName;
//            return new ResponseBean(200,"上传图片成功",path);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseBean(500,"上传图片失败",null);
//        }

        try {
            String path = uploadUtil(folder,multipartFile);
            return new ResponseBean(200,"上传图片成功",path);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseBean(500,"上传图片失败",null);
        }
    }

    @RequestMapping("/deleteCover")
    @ResponseBody
    public ResponseBean deleteCover(@RequestParam("path") String path){
        //获取照片的磁盘路径
        String replace = path.replace(imgWeb, imgUrl);
        //创建文件
        File  file = new File(replace);
        //删除
        file.delete();
        return new ResponseBean(200,"删除封面成功",null);
    }

    @RequestMapping("/uploadEditorImage")
    @ResponseBody
    public ResponseBean uploadEditorImage(@RequestParam("folder") String folder,@RequestParam("upfile[]") MultipartFile[] multipartFile) throws IOException {
        //定义集合用于存储所有图片的路径
        ArrayList pathList = new ArrayList<String>();
        //将图片上传到folder文件夹中
        for(MultipartFile file: multipartFile){
            String path = uploadUtil(folder,file);
            pathList.add(path);
        }
        //返回图片的网络路径
        return new ResponseBean(200,"成功" , pathList);
    }

    //文件上传的的工具类
    public  String uploadUtil(String folder,MultipartFile multipartFile) throws IOException{
        //获取文件名
        String originalFilename = multipartFile.getOriginalFilename();
        //随机生成一个文件名
        String uuid = UUID.randomUUID().toString().replace("-","");
        //获取图片扩展名
        String extension = FilenameUtils.getExtension(originalFilename);
        //获取新的文件名
        String newFileName = uuid + "." +extension;
        //声明放置头像的目录
        File directory = new File(imgUrl + folder);
        //判断目录是否存在，如果不存在生成该目录
        if(!directory.exists()){
            directory.mkdir();
        }
            //开始存放
            multipartFile.transferTo(new File(directory,newFileName));
            //新的图片的网络路径
            String path = imgWeb + folder + newFileName;
            //返回文件路径
             return path;
    }
}
