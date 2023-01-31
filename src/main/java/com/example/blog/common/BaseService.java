package com.example.blog.common;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author 言曌
 * @date 2019-09-04 22:47
 */
// JDK8函数式接口注解 仅能包含一个抽象方法
public interface BaseService<E, ID extends Serializable> {

    /**
     * @return
     */
    BaseMapper<E> getRepository();

    /**
     * 根据ID获取
     *
     * @param id
     * @return
     */
    default E get(ID id) {
        return getRepository().selectById(id);
    }

    /**
     * 获取所有列表
     *
     * @return
     */
    default List<E> getAll() {
        return getRepository().selectList(null);
    }

    /**
     * 获取总数
     *
     * @return
     */
    default Integer getTotalCount() {
        return getRepository().selectCount(null);
    }

    /**
     * 添加
     *
     * @param entity
     * @return
     */
    default E insert(E entity) {
        getRepository().insert(entity);
            return entity;
    }

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    default E update(E entity) {
        getRepository().updateById(entity);
        return entity;
    }

    /**
     * 保存或者更新
     * @param entity
     * @return
     */
    default E insertOrUpdate(E entity) {
        try {
            Object id = entity.getClass().getMethod("getId").invoke(entity);
            if (id != null) {
                update(entity);
            } else {
                insert(entity);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return entity;
    }

    /**
     * 批量保存与修改
     *
     * @param list
     * @return
     */
    default List<E> batchInsert(List<E> list) {
        for (E e : list) {
            getRepository().insert(e);
        }
        return list;
    }


    /**
     * 根据Id删除
     *
     * @param id
     */
    default void delete(ID id) {
        getRepository().deleteById(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    default void batchDelete(List<ID> ids) {
        if(ids != null && ids.size() > 0) {
            getRepository().deleteBatchIds(ids);
        }
    }


    /**
     * 根据id批量查询
     * @param ids
     * @return
     */
    default List<E> findByBatchIds(List<ID> ids) {
        return getRepository().selectBatchIds(ids);
    }

    /**
     * 获取所有
     *
     * @return
     */
    default List<E> findAll() {
        return getRepository().selectList(null);
    }

    /**
     * 根据条件查询获取
     *
     * @param queryWrapper
     * @return
     */
    default List<E> findAll(LambdaQueryWrapper<E> queryWrapper) {
        return getRepository().selectList(queryWrapper);
    }


    /**
     * 分页获取
     *
     * @param page
     * @return
     */
    default Page<E> findAll(Page<E> page, LambdaQueryWrapper<E> queryWrapper) {
        return (Page<E>) getRepository().selectPage(page, queryWrapper);
    }

    /**
     * 分页获取
     *
     * @param page
     * @return
     */
    default Page<E> findAll(Page<E> page) {
        return (Page<E>) getRepository().selectPage(page, null);
    }


    /**
     * 获取查询条件的结果数
     *
     * @param queryWrapper
     * @return
     */
    default long count(QueryWrapper<E> queryWrapper) {
        return getRepository().selectCount(queryWrapper);
    }

}

