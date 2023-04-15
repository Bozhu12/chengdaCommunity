package com.sans.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 评论表
 * @TableName comment
 */
@TableName(value ="comment")
@Data
public class Comment implements Serializable {
    /**
     * 评论ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 作者ID，外键关联用户表
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 帖子ID，外键关联帖子表
     */
    @TableField(value = "post_id")
    private Long postId;

    /**
     * 父评论ID，表示该评论是回复哪条评论的
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 评论内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 评论状态，0表示正常，1表示删除
     */
    @TableField(value = "status")
    private Long status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}