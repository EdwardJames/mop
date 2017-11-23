package com.xp.springboot.mop.service;

import java.util.List;

import com.xp.springboot.mop.domain.upload.UploadPictureRecord;

public interface UploadPicService {
     int testOne();
     /**
      * 
     * @Title: batchSavePicture 
     * @Description: 批量保存图片插入
     * @param @param recordList
     * @param @return     
     * @return List<UploadPictureRecord>    
     * @author peng.xu
     * @date 2017年8月30日 下午3:38:23  
     * @throws
      */
     public List<UploadPictureRecord> batchSavePicture(List<UploadPictureRecord> recordList);
}
