package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("selectAllBanner")
    public Map<String,Object> selectAllBanner(Integer page,Integer rows){
        Map<String, Object> map = bannerService.selectAllBanner(page, rows);
        return map;
    }

    @RequestMapping("edit")
    public Map<String,Object> edit(String oper, Banner banner){
        Map<String,Object> map = new HashMap<>();
        if(oper.equals("add")){
            map = add(banner);
        }
        if(oper.equals("edit")){
            map = edit(banner);
        }
        if(oper.equals("del")){
            map = del(banner);
        }
        return map;
    }

    public Map<String,Object> add(Banner banner){
        Map<String,Object> map = new HashMap<>();
        try {
            String id = bannerService.add(banner);
            map.put("status",true);
            map.put("message",id);
        } catch (Exception e) {
            map.put("status",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    public Map<String,Object> edit(Banner banner){
        Map<String,Object> map = new HashMap<>();
        try {
            bannerService.edit(banner);
            map.put("status",true);
        } catch (Exception e) {
            map.put("status",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    public Map<String,Object> del(Banner banner){
        Map<String,Object> map = new HashMap<>();
        try {
            bannerService.del(banner.getId());
            map.put("status",true);
        } catch (Exception e) {
            map.put("status",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    @RequestMapping("upload")
    public Map<String,Object> upload(MultipartFile file, String id, HttpServletRequest request){
//        文件上传
//        修改banner的文件名
        Map<String,Object> map = new HashMap<>();
        try {
            file.transferTo(new File(request.getSession().getServletContext().getRealPath("/other/banner/img"),file.getOriginalFilename()));
            Banner banner = new Banner();
            banner.setId(id);
            banner.setFile(file.getOriginalFilename());
            bannerService.edit(banner);
            map.put("status",true);
        } catch (IOException e) {
            map.put("status",false);
        }
        return map;
    }




}
