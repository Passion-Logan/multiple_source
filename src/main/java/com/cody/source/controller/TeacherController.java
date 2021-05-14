package com.cody.source.controller;

import com.cody.source.entity.Teacher;
import com.cody.source.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Teacher)表控制层
 *
 * @author wql
 * @since 2021-05-14 23:17:11
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
//    @DS("slave_1")
    public Teacher selectOne(Long id) {
        return teacherService.queryById(id);
//        return teacherService.getById(id);
    }

}
