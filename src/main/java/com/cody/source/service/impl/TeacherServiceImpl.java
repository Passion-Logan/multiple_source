package com.cody.source.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cody.source.dao.TeacherDao;
import com.cody.source.entity.Teacher;
import com.cody.source.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Teacher)表服务实现类
 *
 * @author wql
 * @since 2021-05-14 23:17:11
 */
@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements TeacherService {
    @Resource
    private TeacherDao teacherDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Teacher queryById(Long id) {
        return this.teacherDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Teacher> queryAllByLimit(int offset, int limit) {
        return this.teacherDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher insert(Teacher teacher) {
        this.teacherDao.insert(teacher);
        return teacher;
    }

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher update(Teacher teacher) {
        this.teacherDao.update(teacher);
        return this.queryById(teacher.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.teacherDao.deleteById(id) > 0;
    }
}
