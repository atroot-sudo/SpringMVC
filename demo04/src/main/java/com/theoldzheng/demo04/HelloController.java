package com.theoldzheng.demo04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Description: HelloController 控制器
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.13 10:42
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/upload")
    public String upload(@RequestParam(value = "username", required = false) String username,
                         Model model,
                         @RequestParam(value = "headerImg") MultipartFile multipartFile) {
        System.out.println("文件上传信息");
        System.out.println("文件名：" + multipartFile.getName());
        System.out.println(multipartFile.getOriginalFilename());

        //文件保存
        try {
            multipartFile.transferTo(new File("E:\\DownLoad\\" + multipartFile.getOriginalFilename()));
            model.addAttribute("msg", "文件上传成功!");
        } catch (IOException e) {
            model.addAttribute("msg", "文件上传失败!");
            e.printStackTrace();
        }

        return "success";
    }

    @RequestMapping(value = "/uploadMore")
    public String uploadMore(@RequestParam(value = "username", required = false) String username,
                             Model model,
                             @RequestParam(value = "headerImg") MultipartFile[] multipartFile) {

        for (MultipartFile file : multipartFile) {
            if (!file.isEmpty()) {
                System.out.println("文件上传信息:");
                System.out.println("文件名：" + file.getName());
                System.out.println(file.getOriginalFilename());

                //文件保存
                try {
                    file.transferTo(new File("E:\\DownLoad\\" + file.getOriginalFilename()));
                    model.addAttribute("msg", "文件上传成功!");
                } catch (IOException e) {
                    model.addAttribute("msg", "文件上传失败!");
                    e.printStackTrace();
                }
            }
        }


        return "success";
    }


}
