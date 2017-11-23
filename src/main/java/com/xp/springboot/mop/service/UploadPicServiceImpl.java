package com.xp.springboot.mop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.springboot.mop.domain.upload.UploadPictureRecord;
import com.xp.springboot.mop.mapper.UploadPictureRecordMapper;

@Service("uploadPicService")
public class UploadPicServiceImpl implements UploadPicService{
    
    @Autowired
    private UploadPictureRecordMapper uploadPictureRecordMapper;

    @Override
    public int testOne() {
        return 1;
    }

    @Override
    public List<UploadPictureRecord> batchSavePicture(List<UploadPictureRecord> recordList) {
        Integer status = uploadPictureRecordMapper.batchSavePicture(recordList);
        if(status!=null){
            return recordList;
        }
        return null;
    }

}
