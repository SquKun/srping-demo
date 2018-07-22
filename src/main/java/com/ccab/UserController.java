package com.ccab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有数据
     *
     * @return
     */
    @GetMapping(value = "/userget")
    public List<NewUser> userList() {
        return userRepository.findAll();
    }

    /**
     *
     */
    @PostMapping(value = "/userpost")
    public NewUser addUser( @RequestParam("userCreatetime") Date userCreatetime,
                            @RequestParam("userNickname") String userNickname,
                            @RequestParam("userPassword") String userPassword,
                            @RequestParam("userType") Integer userType,
                            @RequestParam("userUpdatetime") Date userUpdatetime) {

        NewUser user = new NewUser();
        user.setUserType(userType);
        user.setUserCreatetime(userCreatetime);
        user.setUserUpdatetime(userUpdatetime);
        user.setUserNickname(userNickname);
        user.setUserPassword(userPassword);
        return userRepository.save(user);
    }
}
