package com.xp.springboot.mop.util.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import java.util.Properties;

/**
 * Created by tengyu on 2017/6/14.
 */
public class MailUtil {

    private static Logger logger = LoggerFactory.getLogger(MailUtil.class);

    // 设置服务器
    private static String KEY_SMTP = "mail.smtp.host";
    private static String VALUE_SMTP = "smtp.exmail.qq.com";
    // 服务器验证
    private static String KEY_PROPS = "mail.smtp.auth";
    private static boolean VALUE_PROPS = true;
    // 建立会话
    private MimeMessage message;
    private Session s;

    /*
     * 初始化方法
     */
    public MailUtil(String sendName,String sendPwd) {
        Properties props = System.getProperties();
        props.setProperty(KEY_SMTP, VALUE_SMTP);
        props.put(KEY_PROPS, "true");
        //props.put("mail.smtp.auth", "true");
        s =  Session.getDefaultInstance(props, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendName, sendPwd);
            }});
        s.setDebug(true);
        message = new MimeMessage(s);
    }

    /**
     * 发送邮件
     *
     * @param headName
     *            邮件头文件名
     * @param sendHtml
     *            邮件内容
     * @param receiveUser
     *            收件人地址
     */
    public void doSendHtmlEmail(String headName, String sendHtml,
                                String receiveUser,String sendName,String sendPwd) {
        try {
            // 发件人
            InternetAddress from = new InternetAddress(sendName);
            message.setFrom(from);
            // 收件人
            InternetAddress to = new InternetAddress(receiveUser);
            message.setRecipient(Message.RecipientType.TO, to);
            // 邮件标题
            message.setSubject(headName);
//            String content = sendHtml.toString();
            // 邮件内容,也可以使纯文本"text/plain"
            message.setContent(sendHtml, "text/html;charset=GBK");
            message.saveChanges();
            Transport transport = s.getTransport("smtp");
            // smtp验证，就是你用来发邮件的邮箱用户名密码
            transport.connect(VALUE_SMTP, sendName, sendPwd);
            // 发送
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("send success!");
        } catch (AddressException e) {
            logger.error("[MailUtil:发送邮件异常]",e);
        } catch (MessagingException e) {
            logger.error("[MailUtil:发送邮件异常]",e);
        }
    }

    public static void main(String[] args) {
        String SEND_UNAME = "peng.xu@mljr.com";
        String SEND_PWD = "Xupeng199257";
        MailUtil se = new MailUtil(SEND_UNAME,SEND_PWD);
        String content = "this is content";
        System.out.println(content);
        se.doSendHtmlEmail("handname", content, "peng.xu@mljr.com",SEND_UNAME,SEND_PWD);
        System.out.println("mail sened");
    }

}
