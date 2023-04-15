package com.sans.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 帖子表
 * @TableName post
 */
@TableName(value ="post")
@Data
public class Post implements Serializable {
    /**
     * 帖子id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 帖子标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 帖子内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 作者ID，外键关联用户表
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 分类ID
     */
    @TableField(value = "category_id")
    private Long categoryId;

    /**
     * 帖子状态，0正常，1删除
     */
    @TableField(value = "status")
    private Long status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}