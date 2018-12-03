package com.tensquare.base.service.impl;

import Util.IdWorker;
import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.service.LabelService;
import com.tensquare.base.pojo.Label;
import entity.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
    public List<Label> findSearch(Label label) {
       return labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                ArrayList<Predicate> predicateList = new ArrayList<>();
                if (!StringUtils.isBlank(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    predicateList.add(predicate);
                }
                if (!StringUtils.isBlank(label.getState())) {
                    Predicate state = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                    predicateList.add(state);
                }

                Predicate[] predicates = new Predicate[predicateList.size()];
                Predicate[] predicates1 = predicateList.toArray(predicates);
                return criteriaBuilder.and(predicates1);

            }
        });
    }

    @Override
    public void update(Label label) {

    }

    @Override
    public void deleteById(String id) {

    }


    @Override
    public Page<Label> findPage(Label label, int page, int size) {
        return labelDao.findAll(new Specification<Label>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                ArrayList<Predicate> predicateList = new ArrayList<>();
                if (!StringUtils.isBlank(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    predicateList.add(predicate);
                }
                if (!StringUtils.isBlank(label.getState())) {
                    Predicate state = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                    predicateList.add(state);
                }

                Predicate[] predicates = new Predicate[predicateList.size()];
                Predicate[] predicates1 = predicateList.toArray(predicates);
                return criteriaBuilder.and(predicates1);

            }
        }, PageRequest.of(page - 1, size));
    }
}
