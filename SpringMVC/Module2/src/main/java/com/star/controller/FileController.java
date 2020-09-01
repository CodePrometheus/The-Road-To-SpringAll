package com.star.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping("download")
    public void downLoad(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("下载文件的名称: " + fileName);
        String realPath = request.getSession().getServletContext().getRealPath("/down");

//        通过文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
//        获取响应输出流
        response.setContentType("text/plain;charset=UTF-8");
//        附件下载  attachment附件  inline在线打开
        response.setHeader("content-disposition", "inline;fileName=" + URLEncoder.encode(fileName,"UTF-8"));
        ServletOutputStream os = response.getOutputStream();

        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
/*
        int len;
        byte[] bytes = new byte[1024];
        while (true) {
            len = is.read(bytes);
            if (len == -1) {
                break;
            }
            os.write(bytes, 0, len);
        }
        is.close();
        os.close();
*/
    }

    @PostMapping("upload")
    public String upload(MultipartFile img, HttpServletRequest request) throws IOException {
        System.out.println("文件名" + img.getOriginalFilename());
        System.out.println("文件大小" + img.getSize());
        System.out.println("文件类型" + img.getContentType());

//        文件上传
        String realPath = request.getSession().getServletContext().getRealPath("/upload");

//        修改文件原始名称
        String extension = FilenameUtils.getExtension(img.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString().replace("-", "") + "." + extension;

//        生成当天的目录
        LocalDate now = LocalDate.now();
        File dateDir = new File(realPath, now.toString());
        if (!dateDir.exists()) {
            dateDir.mkdirs();
        }


        img.transferTo(new File(dateDir, newFileName));

        return "index";
    }
}
