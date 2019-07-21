package com.baizhi.service;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Map<String, Object> selectAllArticle(Integer page, Integer rows) {
        Article article = new Article();
        RowBounds rowBounds = new RowBounds((page-1)*rows,rows);
        List<Article> articles = articleDao.selectByRowBounds(article, rowBounds);
        int count = articleDao.selectCount(article);
        Map<String, Object> map = new HashMap<>();
        map.put("page",page);
        map.put("rows",articles);
        map.put("records",count);
        map.put("total",count%rows==0?count/rows:count/rows+1);
        return map;
    }

    @Override
    public void add(Article article) {
        article.setId(UUID.randomUUID().toString());
        article.setCreateDate(new Date());
        int i = articleDao.insertSelective(article);
        if(i == 0){
            throw new RuntimeException("添加文章失败");
        }
    }

    @Override
    public void edit(Article article) {
        int i = articleDao.updateByPrimaryKeySelective(article);
        if(i == 0){
            throw new RuntimeException("修改文章失败");
        }
    }

    @Override
    public void del(Article article) {
        int i = articleDao.deleteByPrimaryKey(article.getId());
        if(i == 0){
            throw new RuntimeException("删除文章失败");
        }
    }
}
