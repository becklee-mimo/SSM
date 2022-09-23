package com.atguigu.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileUpAndDownController {

    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
            //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/img/1.png");
        System.out.println("realPath = " + realPath);
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的默认名字
        headers.add("Content-Disposition", "attachment;filename=1.png");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
        //关闭输入流
        is.close();
        return responseEntity;

    }

    @RequestMapping("/test/up")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        String filename = photo.getOriginalFilename();
        //获取文件名的后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //生成uuid
        String uuid = UUID.randomUUID().toString();
        //uuid + 后缀名(比如.jpg)构成新的文件名
        filename = uuid + suffixName;
        ServletContext servletContext = session.getServletContext();
        //获取当前工程下photo的真实路径
        String photoPath = servletContext.getRealPath("photo");
        //创建photoPath对应的File对象
        File file = new File(photoPath);
        //如果工程中没有这个目录就创建
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + filename;
        //上传
        photo.transferTo(new File(finalPath));
        return "success";

    }
}
