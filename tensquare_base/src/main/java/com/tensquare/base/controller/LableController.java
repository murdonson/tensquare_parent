package com.tensquare.base.controller;

import Util.IdWorker;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jzy on 2018/12/3.
 */

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LableController {

    @Autowired
    private LabelService labelService;
    @Autowired
    private IdWorker idWorker;
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true,labelService.findAll(),"查询成功",StatusCode.OK );
    }

    @RequestMapping(value = "/{lableId}", method = RequestMethod.GET)
    public Result FindById(@PathVariable("lableId") String lableId) {
        return new Result(true, labelService.findByID(lableId), "查询成功", StatusCode.OK);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public Result add(@RequestBody Label label) {
        label.setId(idWorker.nextId()+"");
        labelService.add(label);
        return new Result(true, StatusCode.OK, "增加成功");
    }


    // 根据条件查询
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label) {
        List<Label> labelList= labelService.findSearch(label);
        return new Result(true, labelList, "查询成功", StatusCode.OK);
    }


    //  根据条件分页查询
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result findPage(@RequestBody Label label,@PathVariable("page") int page,@PathVariable("size") int size) {

        Page<Label> pageList= labelService.findPage(label, page, size);
        return new Result(true, new PageResult<Label>(pageList.getTotalElements(),pageList.getContent()), "查询成功", StatusCode.OK);

    }



}

