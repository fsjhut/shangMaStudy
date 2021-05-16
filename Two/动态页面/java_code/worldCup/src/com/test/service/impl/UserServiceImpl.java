package com.test.service.impl;

import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;
import com.test.entity.User;
import com.test.service.UserService;

import java.util.ArrayList;

/**
 * @className: UserServiceImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/5/15 14:35
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User selectByName(String userName) {
        return userDao.selectByName(userName);
    }

    @Override
    public Integer getCardNo(User myUser) {
        // 业务逻辑  判断用户已抽中了多少次
        ArrayList<Integer> getCard = myUser.getGetCard();
        ArrayList<Integer> noCard = myUser.getNoCard();
        Integer cardNo;
        if(noCard==null||noCard.size()==0){
            cardNo = (int)(Math.random()*4 + 1);
            return cardNo;
        }
        int getCardNo = getCard.size();
        int noCardNo = noCard.size();
        if(getCardNo>=3 && getCardNo<=5 && noCardNo<=1){
            // 抽了3-5次，获取了3张不同的卡片，则从已抽中卡池中抽取
            cardNo = getCard.get((int)(Math.random()*getCard.size()));
//            System.out.println(cardNo);
        }else if((getCardNo>=7 && noCardNo<4)||(getCardNo>=8 && noCardNo<3)||(getCardNo>=9 && noCardNo<2)){
            // 抽了7次，全部都一样的，则进行人工干预
            cardNo = noCard.get((int)(Math.random()*noCard.size()));
        }else{
            // 随机抽取 1-4
            cardNo = (int)(Math.random()*4 + 1);
        }
        return cardNo;
    }

    @Override
    public void updateUser(User myUser) {
        // 更新用户数据库信息
        userDao.updateUser(myUser);
    }
}
