import com.hh.dao.UserTestDao;
import com.hh.entity.User;
import com.hh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 15-9-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class MybatisSpring {
    @Autowired
    private UserService userService;
    @Autowired
    private UserTestDao userTestDao;

    @Test
    public void getUserList(){
        List<User> userList = userService.getUserList();
        for(User user:userList){
            System.out.println("---:"+user);
        }
    }

    @Test
    public void getUserListByBaseDao(){
        List<User> userList = userTestDao.getAllUser();
        for(User user:userList){
            System.out.println("---:"+user);
        }
    }
}
