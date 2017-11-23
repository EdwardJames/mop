package com.xp.springboot.mop.upload.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xp.springboot.mop.MopAplicationTest;
import com.xp.springboot.mop.domain.upload.UploadPictureRecord;
import com.xp.springboot.mop.mapper.UploadPictureRecordMapper;
import com.xp.springboot.mop.util.UniqueID;
public class TestUploadMapper extends MopAplicationTest{
    private Logger logger = LoggerFactory.getLogger(TestUploadMapper.class);
    
    @Autowired 
    private UploadPictureRecordMapper uploadMapper;
    
    @Test
    public void testBatchInsert(){
        List<UploadPictureRecord> recordList = new ArrayList<>();
        UploadPictureRecord  record =  new UploadPictureRecord();
        record.setId(UniqueID.generateId());
        record.setArea((short)0);
        record.setCreateTime(new Date());
        record.setDescription("test describtion");
        record.setLabel((short)0);
        record.setLocation("北京三环四环");
        record.setPart((short)0);
        record.setPicName("第一张测试图片");
        record.setStyle((short)0);
        record.setTitle("这是一个标题");
        record.setUploadUser("用户1");
        record.setUserId(1101L);
        record.setApartmentLayout((short)0);
        record.setGroupId((short)0);
        record.setSpace((short)0);
        record.setImagePath("http:///www.baidu.com");
        record.setSource((short)0);
        record.setTopStatus((short)0);
        recordList.add(record);
        
        Integer batchSavePicture = uploadMapper.batchSavePicture(recordList);
        logger.info("插入图片返回状态:"+batchSavePicture);
    }
   
}
