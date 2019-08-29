package fang.controller;

import org.apache.juli.logging.Log;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class IndexController {
    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }
class Image{
    String url;




    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
    @PostMapping("/upload")
    @ResponseBody
    public Image upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        if (file.isEmpty()) {
            return new Image();
        }

        String fileName = file.getOriginalFilename();
        String filePath = "./";
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();

        filePath =  path+"static";
        String url = "/images/files/" + fileName;

        File dest = new File(filePath + url);
        try {
            file.transferTo(dest);
            Image image = new Image();
            image.setUrl(url);
            return image;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new Image();
    }
}
