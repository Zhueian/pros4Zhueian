package com.imooc.pro4pro4Interview.miaosha.servier;

import com.imooc.pro4pro4Interview.miaosha.dao.UserDao;
import com.imooc.pro4pro4Interview.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Auther: qiucy
 * @Date: 2019-05-07 12:58
 * @Description:
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public User getById(int id){
        return userDao.getzById(id);
    }

    @Transactional
    public Boolean insert(){
        User u1 = new User();
        u1.setId(2);
        u1.setName("222");
        userDao.insert(u1);

        User u2 = new User();
        u2.setId(1);
        u2.setName("111");
        userDao.insert(u2);

        return true;
    }
}
