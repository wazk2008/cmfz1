package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
    @Id
    private String id;
    private String title;
    private String size;
    private String duration;
    private String path;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date CreateDate;
    private String albumId;



}
