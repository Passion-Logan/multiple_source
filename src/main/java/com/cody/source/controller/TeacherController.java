package com.cody.source.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cody.source.entity.Teacher;
import com.cody.source.service.TeacherService;
import org.omg.IOP.TaggedComponentHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @DS("slave_1")
    public Teacher selectOne(Long id) {
        return teacherService.queryById(id);
//        return teacherService.getById(id);
    }

    @GetMapping("test")
    @DS("slave_1")
    public void test() {

        IPage<Map<String, Object>> listPage = new Page<>();

        List<Map<String, Object>> page = new ArrayList<>();
        Map<String, Object> temp = new HashMap<>();
        temp.put("name", "test");
        page.add(temp);
        listPage.setRecords(page);

        IPage<Teacher> convert = listPage.convert(e -> coverToTeacher(e));

        for (Teacher record : convert.getRecords()) {
            System.out.println(record.toString());
        }
    }

    private Teacher coverToTeacher(Map<String, Object> maps) {
        return Teacher.builder().name(maps.get("name").toString()).build();
    }

}
