package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RequestMapping("article")
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("upload")
    public Map<String,Object> upload(MultipartFile articleImage, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        try {
            articleImage.transferTo(new File(request.getSession().getServletContext().getRealPath("/img"),articleImage.getOriginalFilename()));
            map.put("error",0);
            map.put("url","img/"+articleImage.getOriginalFilename());
        } catch (IOException e) {
            map.put("error",1);
        }
        return map;
    }

    @RequestMapping("browse")
    public Map<String,Object> browse(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
//        设置文件夹的路径
        String realPath = request.getSession().getServletContext().getRealPath("/img");
        System.out.println("realPath:"+realPath);
        map.put("current_url","http://localhost:8989/cmfz/img/");

//        设置文件夹内的img的数量
        File file = new File(realPath);
        String[] fileNames = file.list();
        map.put("total_count",fileNames.length);

//        设置map中的list集合
        List<Object> list = new ArrayList<Object>();
        for (String fileName : fileNames) {
            Map<String, Object> image = new HashMap<>();
            image.put("is_dir",false);
            image.put("has_file",false);
            File imageFile = new File(realPath, fileName);
            image.put("filesize",imageFile.length());
            image.put("is_photo",true);
            image.put("filetype", FilenameUtils.getExtension(fileName));
            image.put("filename", fileName);
            image.put("datetime", "2018-06-06 00:36:39");
            list.add(image);
        }
        map.put("file_list",list);

        return map;
    }

    @RequestMapping("selectAllArticle")
    public Map<String,Object> selectAllArticle(Integer page,Integer rows){
        Map<String, Object> map = articleService.selectAllArticle(page, rows);
        return map;
    }

    @RequestMapping("edit")
    public Map<String,Object> edit(String oper,Article article){
        System.out.println("oper:"+oper);
        System.out.println(article);
        Map<String, Object> map = new HashMap<>();
        try {
            if("add".equals(oper)){
                articleService.add(article);
            }
            if("edit".equals(oper)){
                articleService.edit(article);
            }
            if("del".equals(oper)){
                articleService.del(article);
            }
            map.put("status",true);
        } catch (Exception e) {
            map.put("status",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

















}
