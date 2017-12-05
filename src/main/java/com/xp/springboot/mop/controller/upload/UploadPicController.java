package com.xp.springboot.mop.controller.upload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.xp.springboot.mop.dto.web.ResponseDTO;
import com.xp.springboot.mop.enums.web.UploadEnum;
import com.xp.springboot.mop.enums.web.WebExceptionEnum;
import com.xp.springboot.mop.util.upload.UploadImg;

@Controller
public class UploadPicController {
    private Logger logger = LoggerFactory.getLogger(UploadPicController.class);
    
    @RequestMapping("/testUpload")
    public Integer testUpload(Model model){
        logger.info("getUserCount start");
        return 0;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
    
    @RequestMapping("/uploadPic")
    public String uploadPic(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "uploadPic";
    }
//    @RequestMapping("/upload/uploadImage")
//    @RequestMapping(method = RequestMethod.POST,value="/upload/uploadImage")
//    public ResponseDTO<List<String>> uploadImage(
//            @RequestParam("file") MultipartFile file,
//            HttpServletRequest request){
//        ResponseDTO<List<String>> responseDTO = new ResponseDTO<>();
//        
//        if(file.isEmpty()){
//            logger.info("文件为空");
//            responseDTO.setCode(-1);
//            responseDTO.setMessage("文件为空");
//            return responseDTO;
//        }
//        String fileName = file.getOriginalFilename();
//        if(!(fileName.endsWith(".png") || fileName.endsWith(".jpg")||fileName.endsWith(".jpeg"))) {
//            logger.info("上传图片类型错误");
//            responseDTO.setCode(WebExceptionEnum.DEFAULT_FAIL.getCode());
//            responseDTO.setMessage("只能上传图片");
//            return responseDTO;
//        }
//        List<String> userIdList = new ArrayList<>();
//        String uuid = UUID.randomUUID().toString().replaceAll("-","");
//        String contentType = file.getContentType();
//        String imageName=contentType.substring(contentType.indexOf("/")+1);  
//        String tempFileName=uuid+"."+imageName;  
//        File myFile = null;
//        try {
//            myFile = File.createTempFile("temp", tempFileName);
//        } catch (IOException e1) {
//            logger.info("创建临时文件出现异常",e1);
//            e1.printStackTrace();
//        }
//        logger.info("准备创建文件:{},path:{}",myFile.getName(),myFile.getAbsolutePath());
//        String resultPath = "";
//        try {
//            file.transferTo(myFile);
//            resultPath =  UploadImg.upload(myFile.getAbsolutePath());
//            logger.info("上传文件返回resultPath:{}",resultPath);
//            boolean deleteFlag = myFile.delete();
//            logger.info("删除文件返回状态:{}",deleteFlag);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       
//        userIdList.add(resultPath);
//        responseDTO.setData(userIdList);
//        return responseDTO;
//    }
    
//    @RequestMapping("/uploadPic")
//    public String uploadPic(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "uploadPic";
//    }
    @RequestMapping("/upload/uploadImageList")
//    @RequestMapping(method = RequestMethod.POST,value="/upload/uploadImage")
    public ResponseDTO<List<String>> uploadImageList(HttpServletRequest request){
        ResponseDTO<List<String>> responseDTO = new ResponseDTO<>();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    logger.info("uploadImageList 上传文件出现异常:{}",e);
                    responseDTO.setCode(WebExceptionEnum.DEFAULT_FAIL.getCode());
                    responseDTO.setMessage(WebExceptionEnum.DEFAULT_FAIL.getName());
                    return responseDTO;
                }
            } else {
                responseDTO.setCode(UploadEnum.EMPTY_FILE.getCode());
                responseDTO.setMessage(UploadEnum.EMPTY_FILE.getName());
                return responseDTO;
            }
        }
        
//        if(file.isEmpty()){
//            logger.info("文件为空");
//            responseDTO.setCode(-1);
//            responseDTO.setMessage("文件为空");
//            return responseDTO;
//        }
//        String fileName = file.getOriginalFilename();
//        if(!(fileName.endsWith(".png") || fileName.endsWith(".jpg")||fileName.endsWith(".jpeg"))) {
//            logger.info("上传图片类型错误");
//            responseDTO.setCode(-1);
//            responseDTO.setMessage("只能上传图片");
//            return responseDTO;
//        }
//        List<String> userIdList = new ArrayList<>();
//        String uuid = UUID.randomUUID().toString().replaceAll("-","");
//        String contentType = file.getContentType();
//        String imageName=contentType.substring(contentType.indexOf("/")+1);  
//        String tempFileName=uuid+"."+imageName;  
//        File myFile = null;
//        try {
//            myFile = File.createTempFile("temp", tempFileName);
//        } catch (IOException e1) {
//            logger.info("创建临时文件出现异常",e1);
//            e1.printStackTrace();
//        }
//        logger.info("准备创建文件:{},path:{}",myFile.getName(),myFile.getAbsolutePath());
//        String resultPath = "";
//        try {
//            file.transferTo(myFile);
//            resultPath =  UploadImg.upload(myFile.getAbsolutePath());
//            logger.info("上传文件返回resultPath:{}",resultPath);
//            boolean deleteFlag = myFile.delete();
//            logger.info("删除文件返回状态:{}",deleteFlag);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       
//        userIdList.add(resultPath);
//        responseDTO.setData(userIdList);
        return responseDTO;
    }
    
}
