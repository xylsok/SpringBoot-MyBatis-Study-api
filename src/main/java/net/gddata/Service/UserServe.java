package net.gddata.Service;

import net.gddata.Dao.UserDao;
import net.gddata.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by zhangzf on 17/10/25.
 */
@Service
public class UserServe {

    @Autowired
    private UserDao userDao;

    public User findById(int id){
        return userDao.findById(id);
    }

    public void save(User user){
        userDao.save(user);
    }
    public List<User> getUsers(){
       return userDao.queryAll();
    }

    public void delUserById(int id) {
        userDao.delById(id);
    }
}
