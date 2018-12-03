package com.tensquare.base.service.impl;

import Util.IdWorker;
import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.service.LabelService;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jzy on 2018/12/3.
 */
@Service
public class LabelServiceImpl implements LabelService {


    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;


    @Override
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    @Override
    public Label findByID(String id) {
        return labelDao.findById(id).get();
    }

    @Override
    public void add(Label label) {
        labelDao.save(label);
    }

    @Override
    public void update(Label label) {

    }

    @Override
    public void deleteById(String id) {

    }
}
