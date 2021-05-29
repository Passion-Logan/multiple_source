package com.cody.source.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.cody.source.annotation.CUSTOMDS;
import com.cody.source.constants.DataSourceConstants;
import com.cody.source.entity.Teacher;
import com.cody.source.entity.User;
import com.cody.source.service.TeacherService;
import com.cody.source.service.UserService;
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
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     * 需要注释掉DynamicDataSourceConfig类的配置
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @DS("slave_1")
    public Teacher selectOne(Long id) {
        return teacherService.getById(id);
    }

    @GetMapping("testCustom")
    @CUSTOMDS(DataSourceConstants.DS_KEY_SLAVE)
    public Teacher testCustom(Long id) {
        return teacherService.getById(id);
    }

    @GetMapping("testMaster")
    public User testMaster(Long id) {
        return userService.getById(id);
    }

}
