package com.groot.blog.base.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Date;

@Data
public class BaseEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后更新时间
     */
    private Date lastUpdateTime;

    /**
     * 判断是否为新的实体类
     *
     * @return 是否为新创建
     */
    public boolean isNew() {
        return StringUtils.isEmpty(this.getId());
    }

    /**
     * 放置基本属性
     *
     */
    public void setCreateProperty() {
        Date date = new Date();
        this.setCreateTime(date);
        this.setLastUpdateTime(date);
    }

    /**
     * 更新基本属性
     *
     */
    public void setUpdateProperty() {
        Date date = new Date();
        this.setLastUpdateTime(date);
    }
}
