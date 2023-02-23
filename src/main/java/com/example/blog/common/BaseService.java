package com.example.blog.common;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
interface CommonConstant {
    Integer STATUS_NORMAL = 0;
    String PASSWORD_SALT = "sens";
    String NONE = "none";
}
/**
 * @author JingxuanWei
 * @apiNote  JDK8函数式接口注解 仅能包含一个抽象方法
 */

public interface BaseService<E, ID extends Serializable> {

    BaseMapper<E> getRepository();

    /**
     * 根据ID
     * @param id 主键ID
     * @return 实体
     */
    default E get(ID id) {
        return getRepository().selectById(id);
    }

    /**
     * 获取所有列表
     * @return List with all info
     * @deprecated 无使用场景
     */
    default List<E> getAll() {
        return getRepository().selectList(null);
    }

    /**
     * @deprecated 无使用场景
     */
    default Integer getTotalCount() {
        Integer count = getRepository().selectCount(null);
        return count == null ? 0 : count;
    }

    /**
     * 添加内容
     * @param entity 实体
     * @return 实体
     */
    default E insert(E entity) {
        getRepository().insert(entity);
        return entity;
    }

    /**
     * 修改内容
     * @param entity 实体
     * @return 实体
     */
    default E update(E entity) {
        getRepository().updateById(entity);
        return entity;
    }

    /**
     * @param entity 实体
     * @return 实体
     * @deprecated 无使用场景
     */
    default E insertOrUpdate(E entity) {
        try {
            Object id = entity.getClass().getMethod("getId").invoke(entity);
            if (id != null) {
                update(entity);
            }
            else {
                insert(entity);
            }
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return entity;
    }

    /**
     * batch insert
     * @param list 实体
     * @return 实体
     * @deprecated 无使用场景
     */
    default List<E> batchInsert(List<E> list) {
        for (E e : list) {
            getRepository().insert(e);
        }
        return list;
    }

    /**
     * delete by id
     * @param id is the id of the entity
     */
    default void delete(ID id) {
        getRepository().deleteById(id);
    }

    /**
     * batchDelete
     * @param allIds is the id of the entity
     */
    default void batchDelete(List<ID> allIds) {
        if(allIds != null ) {
            if (allIds.size() > 0){
                getRepository().deleteBatchIds(allIds);
            }
        }
    }

    /**
     * use id to find entity
     * @param allIds is the id of the entity
     * @return List<E> with all info
     */
    default List<E> findByBatchIds(List<ID> allIds) {
        return getRepository().selectBatchIds(allIds);
    }

    /**
     * get all info not only select * by id
     * @return List<E> with all info
     */
    default List<E> findAll() {
        return getRepository().selectList(null);
    }

    /**
     * get all info by specific condition
     * @param condition 条件
     * @return List<E>
     */
    default List<E> findAll(LambdaQueryWrapper<E> condition) {
        return getRepository().selectList(condition);
    }


    /**
     * 把分页的结果封装到page中全部获取
     * @param page 分页全部
     * @param condition 条件
     * @return 分页结果
     */
    default Page<E> findAll(Page<E> page, LambdaQueryWrapper<E> condition) {
        return (Page<E>) getRepository().selectPage(page, condition);
    }

    /**
     * 只获取单页
     * @param page 分页
     * @return 结果
     * @deprecated 无使用场景
     */
    default Page<E> findAll(Page<E> page) {
        return (Page<E>) getRepository().selectPage(page, null);
    }


    /**
     * 获取查询结果数
     * @param condition 条件
     * @return 结果数
     * @deprecated 无使用场景
     */
    default long count(QueryWrapper<E> condition) {
        return getRepository().selectCount(condition);
    }

}

