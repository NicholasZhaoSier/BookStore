package com.lanou.car.service.impl;

import com.lanou.car.domain.CarBean;
import com.lanou.car.domain.CarBigBean;
import com.lanou.car.cardao.impl.CarDaoImpl;
import com.lanou.car.service.CarService;
import com.lanou.commons.CommonUtils;

import java.util.List;


/**
 * Created by dllo on 17/12/25.
 */
public class CarServiceImpl implements CarService {

    private CarDaoImpl carDao = new CarDaoImpl();


//    @Override
//    public List<CarBean> find(String uid) {
//        return carDao.find(uid);
//    }

    @Override
    public boolean addOrder(CarBean carBean) {
        carBean.setCarid(CommonUtils.uuid());
        return carDao.addOrder(carBean);
    }

    @Override
    public List<CarBigBean> findAll(String uid) {
        return carDao.findAll(uid);
    }

    @Override
    public boolean delByCarId(String carid) {
        return carDao.delByCarId(carid);
    }

    @Override
    public boolean delByUid(String uid) {
        return carDao.delByUid(uid);
    }
}
