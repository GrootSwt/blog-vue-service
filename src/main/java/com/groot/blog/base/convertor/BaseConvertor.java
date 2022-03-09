package com.groot.blog.base.convertor;

import com.groot.blog.base.bean.BaseDTO;
import com.groot.blog.base.bean.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseConvertor<Entity extends BaseEntity, DTO extends BaseDTO> {

    /**
     * entity convert to dto
     *
     * @param entity 实体类
     * @return 数据传输类
     */
    public abstract DTO toDTO(Entity entity);

    /**
     * dto convert to entity
     *
     * @param dto 数据传输类
     * @return 实体类
     */
    public abstract Entity toEntity(DTO dto);

    /**
     * entity list convert to dto list
     *
     * @param entityList 实体类列表
     * @return 数据传输层列表
     */
    public List<DTO> toListDTO(List<Entity> entityList) {
        List<DTO> dtoList = new ArrayList<>();
        for (Entity entity : entityList) {
            DTO dto = this.toDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    /**
     * dto list convert to entity list
     *
     * @param dtoList 数据传输层列表
     * @return 实体类列表
     */
    public List<Entity> toListEntity(List<DTO> dtoList) {
        List<Entity> entityList = new ArrayList<>();
        for (DTO dto : dtoList) {
            Entity entity = this.toEntity(dto);
            entityList.add(entity);
        }
        return entityList;
    }
}
