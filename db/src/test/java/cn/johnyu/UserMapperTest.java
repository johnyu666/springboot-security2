package cn.johnyu;

import cn.johnyu.mapper.UserMapper;
import cn.johnyu.domain.User;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    public void testFindByUsername(){
        User user=userMapper.findByUsername("john");
        System.out.println(user.getId()+"\t"+user.getUsername());
        user.getAuthorities().stream().forEach(role-> System.out.println(role.getAuthority()));
    }
    @Test
    public void test2(){
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        PasswordEncoder encoder=new BCryptPasswordEncoder();

        String s=encoder.encode("123");
        System.out.println(s);
    }
}
