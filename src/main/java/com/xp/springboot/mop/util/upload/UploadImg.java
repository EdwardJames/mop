//package com.xp.springboot.mop.util.upload;
//
//
//import com.qiniu.common.QiniuException;
//import com.qiniu.storage.BucketManager;
//import com.qiniu.storage.UploadManager;
//import com.qiniu.util.Auth;
//import com.xp.springboot.mop.util.trade.IdGenerator;
//
//
//public final class UploadImg {
//	
//	static String ACCESS_KEY = "RBQvyPwEiJhEx5UAg_T1fRu8nLyu4aZawJTpXcg0";
//
//	static String SECRET_KEY = "LQtDhDgmtWwA2IX34AhDOkBZv8Wnf8Gahi-qyFhp";
//	
//	static String bucketname = "fq-mall";
//	
//	static String prefix = "http://img01.yyfq.com/";
//	
//	static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
//	
//	static UploadManager uploadManager = new UploadManager();
//
//	static BucketManager bucketManager = new BucketManager(auth);
//
//	public static String getUpToken(String key) {
//		return auth.uploadToken(bucketname, key);
//	}
//
//
//	public static String upload(String path, String key) {
//		try {
//			uploadManager.put(path, key, getUpToken(key));
//			return prefix + key;
//		} catch (QiniuException e) {
//			return null;
//		}
//	}
//	
//
//	public static String upload(String path) {
//		try {
//			String key = String.valueOf(IdGenerator.generateNumberId());
//			if (path.lastIndexOf(".") >= 0) {
//				key += path.substring(path.lastIndexOf("."));
//			}
//			uploadManager.put(path, key, getUpToken(key));
//			return prefix + key;
//		} catch (QiniuException e) {
//			return null;
//		}
//	}
//	/**
//	 *     @RequestMapping(method = RequestMethod.POST,value="/upload/uploadImage")
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
//        return responseDTO;
//    }
//	 */
//
//}