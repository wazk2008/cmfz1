package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public Map<String, Object> selectAllBanner(Integer page, Integer rows) {
        Map<String,Object> map = new HashMap<String,Object>();
        Banner banner = new Banner();
        RowBounds rowBounds = new RowBounds((page - 1) * rows, rows);
        List<Banner> banners = bannerDao.selectByRowBounds(banner, rowBounds);
        int count = bannerDao.selectCount(banner);
        map.put("page",page); //当前页码
        map.put("rows",banners); //当前页的数据
        map.put("total",count%rows==0?count/rows:count/rows+1); //总页数
        map.put("records",count); //总条数
        return map;
    }

    @Override
    public String add(Banner banner) {
        String id = UUID.randomUUID().toString();
        banner.setId(id);
        banner.setCreateDate(new Date());
        int i = bannerDao.insert(banner);
        if(i == 1){
            return id;
        }else{
            throw new RuntimeException("添加轮播图失败");
        }
    }

    @Override
    public void edit(Banner banner) {
        int i = bannerDao.updateByPrimaryKeySelective(banner);
        if(i == 0){
            throw new RuntimeException("修改轮播图失败");
        }
    }

    @Override
    public void del(String id) {
        int i = bannerDao.deleteByPrimaryKey(id);
        if(i == 0){
            throw new RuntimeException("删除轮播图失败");
        }
    }
}
