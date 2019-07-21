package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
   @Id
   private String id;
   private String title;
   private String cover;
   private Integer count;
   private Integer score;
   private String author;
   private String broadcast;
   private String brief;
   @JSONField(format = "yyyy-MM-dd HH:mm:ss")
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private Date createDate;


}
