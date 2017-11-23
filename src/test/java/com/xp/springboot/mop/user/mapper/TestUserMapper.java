package com.xp.springboot.mop.user.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xp.springboot.mop.domain.user.User;
import com.xp.springboot.mop.mapper.UserMapper;
import com.xp.springboot.mop.util.UniqueID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserMapper {
    private Logger logger = LoggerFactory.getLogger(TestUserMapper.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testBatchInsert() {
        List<User> userList = new ArrayList<>();
        // for(int j=0;j<3;j++){
        for (int i = 1; i <= 1; i++) {

            User user = new User();
            Random random = new Random();
            int randomAge = random.nextInt(80) + 1;
            user.setAge((short) randomAge);
            user.setMobile("1371692899" + randomAge);
            user.setPassword("password");
            user.setId(UniqueID.generateId());
            user.setUserName("");
            userList.add(user);

        }
        long start = System.currentTimeMillis();
        Integer status = userMapper.batchInsert(userList);
        logger.info("插入返回:{},耗时:{}", status, System.currentTimeMillis() - start);
        // }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("this is good ");
    }

}
