package net.gddata.ui;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.gddata.Service.RedisService;
import net.gddata.Service.UserServe;
import net.gddata.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangzf on 17/10/25.
 */
@Api(value = "用户管理", description = "用户管理")
@RestController
@RequestMapping(value = "/user")
public class UserWeb {
    @Autowired
    UserServe userServe;

    @Autowired
    private RedisService redisService;

    private boolean redisReady = false;

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private void addUser(@RequestBody User user) {
        userServe.save(user);
    }

    @ApiOperation(value = "查询用户", notes = "查询用户")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    private User getUser(@PathVariable int id) {
        return userServe.findById(id);
    }

    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    private List<User> getUsers() {
        List<User> users = userServe.getUsers();
        for (User user : users) {
            redisService.set(user.getUsername(),user.toString(),120L, TimeUnit.SECONDS);
        }
        return users;
    }

    @ApiOperation(value = "根据Username查询用户", notes = "根据Username查询用户")
    @RequestMapping(value = "/getuserbyusername", method = RequestMethod.GET)
    public Object getUserByUserName(@RequestParam String username){
        return redisService.get(username);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    private void del(@PathVariable int id) {
         userServe.delUserById(id);
    }
}
