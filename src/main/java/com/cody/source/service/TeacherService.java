package com.cody.source.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cody.source.entity.Teacher;

import java.util.List;

/**
 * (Teacher)表服务接口
 *
 * @author wql
 * @since 2021-05-14 23:17:11
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Teacher queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Teacher> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    Teacher insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    Teacher update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
