package com.sans.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户帖子表
 * @author Sans
 * @TableName user_post
 */
@TableName(value ="user_post")
@Data
public class UserPost implements Serializable {
    /**
     * 用户帖子表id
     */
    @TableId(value = "post_id")
    private Long postId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

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
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 帖子点赞数
     */
    @TableField(value = "like_count")
    private Long likeCount;

    /**
     * 帖子浏览数
     */
    @TableField(value = "view_count")
    private Long viewCount;

    /**
     * 帖子回复数
     */
    @TableField(value = "reply_count")
    private Long replyCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}