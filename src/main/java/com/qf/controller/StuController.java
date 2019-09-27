package com.qf.controller;

import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName: StuController
 * @Author: 53074
 * Date: 2019/9/25
 */
@Controller
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private IStuService stuService;

    @RequestMapping("/list")
    public String queryall(ModelMap map){
        List<Student> studentList=stuService.list();
        map.put("studentList", studentList);

        return "stulist";
    }

    @RequestMapping("/delete")
    public String delete(int id){
        System.out.println(id);
        stuService.removeById(id);
        return "redirect:/stu/list";
    }

    @RequestMapping("/toupdate")
    public String getStuById(int id,ModelMap map){
        Student stu = stuService.getById(id);
        map.put("stu", stu);
        return "stuupdate";
    }

    @RequestMapping("/update")
    public String update(Student student){
        int id = student.getId();
        stuService.saveOrUpdate(student);
        return "redirect:/stu/list";
    }

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/save")
    public String savestu(Student student){
        stuService.saveOrUpdate(student);
        return "redirect:/stu/list";
    }

}
