import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xsk.BatisApplication;
import com.xsk.entity.User;
import com.xsk.entity.mapper.UserMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BatisApplication.class)
public class BaseTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        List<User> users = userMapper.selectList(null);
        users.forEach(e -> {
            System.out.println(e.toString());
        });
    }

    @Test
    public void test2() {

        List<User> users = userMapper.getUserList();
        TestCase.assertFalse(users.isEmpty());


        IPage<User> page = userMapper.selectPage(
                new Page<User>(1, 2),
                new QueryWrapper<User>().gt("age",10)
        );
        List<User> users1 = page.getRecords();
         TestCase.assertFalse(page.getRecords().isEmpty());
    }
}
