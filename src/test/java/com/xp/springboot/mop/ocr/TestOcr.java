package com.xp.springboot.mop.ocr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class TestOcr {

    private static final String LANG_OPTION = "-l";
    /**
     * 文件位置我防止在，项目同一路径
     */
    private static String tessPath = "F:\\developer\\OCR\\Tesseract-OCR";

    /**
     * @param imageFile
     *            传入的图像文件
     * @param imageFormat
     *            传入的图像格式
     * @return 识别后的字符串
     * @throws IOException
     * @throws InterruptedException
     */
    public static synchronized String recognizeText(File imageFile) throws IOException, InterruptedException {
        /**
         * 设置输出文件的保存的文件目录
         */
        File outputFile = new File(imageFile.getParentFile(), "output");

        StringBuffer strB = new StringBuffer();
        List<String> cmd = new ArrayList<String>();
        cmd.add(tessPath + "\\tesseract");
        cmd.add("");
        cmd.add(outputFile.getName());
        cmd.add(LANG_OPTION);
        // cmd.add("chi_sim");
        cmd.add("eng");

        ProcessBuilder pb = new ProcessBuilder();
        /**
         * Sets this process builder's working directory.
         */
        pb.directory(imageFile.getParentFile());
        cmd.set(1, imageFile.getName());
        pb.command(cmd);
        pb.redirectErrorStream(true);
        System.out.println("执行命令：" + JSONObject.toJSONString(cmd));
        Process process = pb.start();
        // tesseract.exe 1.jpg 1 -l chi_sim
        // Runtime.getRuntime().exec("tesseract.exe 1.jpg 1 -l chi_sim");
        /**
         * the exit value of the process. By convention, 0 indicates normal
         * termination.
         */
        // System.out.println(cmd.toString());
        int w = process.waitFor();
        if (w == 0)//0代表正常退出
        {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(outputFile.getAbsolutePath() + ".txt"), "UTF-8"));
            in.close();
        } else {
            String msg;
            switch (w) {
            case 1:
                msg = "Errors accessing files. There may be spaces in your image's filename.";
                break;
            case 29:
                msg = "Cannot recognize the image or its selected region.";
                break;
            case 31:
                msg = "Unsupported image format.";
                break;
            default:
                msg = "Errors occurred.";
            }
            throw new RuntimeException(msg);
        }
        new File(outputFile.getAbsolutePath() + ".txt");
        return strB.toString().replaceAll("\\s*", "");
    }

    public static void main(String[] args) {
        try {
            //System.out.println(recognizeText(new File("F:/developer/OCR/number.png")));//数字可以识别
//            System.out.println(recognizeText(new File("F:/developer/OCR/zimu1.png")));//字母可以识别
            System.out.println(recognizeText(new File("F:/developer/OCR/numberWithPoint.png")));//字母可以识别
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
