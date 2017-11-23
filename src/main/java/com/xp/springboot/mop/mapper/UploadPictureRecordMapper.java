package com.xp.springboot.mop.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xp.springboot.mop.domain.upload.UploadPictureRecord;


public interface UploadPictureRecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UploadPictureRecord record);

    int insertSelective(UploadPictureRecord record);

    UploadPictureRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UploadPictureRecord record);

    int updateByPrimaryKey(UploadPictureRecord record);
    
    Integer batchSavePicture(@Param("recordList")List<UploadPictureRecord> recordList);
}