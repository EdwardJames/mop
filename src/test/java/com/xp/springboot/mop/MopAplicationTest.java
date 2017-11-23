package com.xp.springboot.mop;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MopAplicationTest {
    private static Logger logger = LoggerFactory.getLogger(MopAplicationTest.class);
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MopAplicationTest.class, args);
        //运维启动脚本必须检测到有server startup才认为正常启动
        logger.info("==================================");
        logger.info("LeaseOrder Server startup");
        logger.info("==================================");
    }

}
