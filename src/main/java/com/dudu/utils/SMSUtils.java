package com.dudu.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

import java.rmi.ServerException;

/**
 * 短信发送工具类
 */
public class SMSUtils {

	/**
	 * 发送短信
	 * @param signName 签名
	 * @param templateCode 模板
	 * @param phoneNumbers 手机号
	 * @param param 参数
	 */
	//		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tKMYTx4DNgFaVFGJaSG", "GjOuzGsXlEzH05xqXs74FUlqxH3Vzo");
//		IAcsClient client = new DefaultAcsClient(profile);
//
//		SendSmsRequest request = new SendSmsRequest();
//		request.setSysRegionId("cn-hangzhou");
//		request.setPhoneNumbers(phoneNumbers);
//		request.setTemplateCode(templateCode);
//		request.setSignName(signName);
//		request.setTemplateParam("{\"code\":\""+param+"\"}");
//		try {
//			SendSmsResponse response = client.getAcsResponse(request);
//			System.out.println("短信发送成功");
//		}catch (ClientException e) {
//			e.printStackTrace();
//		}
//	}
	public static void sendMessage(String signName, String templateCode,String phoneNumbers,String param){

	DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tKMYTx4DNgFaVFGJaSG", "GjOuzGsXlEzH05xqXs74FUlqxH3Vzo");
	/** use STS Token
	 DefaultProfile profile = DefaultProfile.getProfile(
	 "<your-region-id>",           // The region ID
	 "<your-access-key-id>",       // The AccessKey ID of the RAM account
	 "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
	 "<your-sts-token>");          // STS Token
	 **/

	IAcsClient client = new DefaultAcsClient(profile);


	SendSmsRequest request = new SendSmsRequest();
        request.setSignName(signName);
        request.setTemplateCode(templateCode);
        request.setPhoneNumbers(phoneNumbers);
        request.setTemplateParam("{\"code\":\"" + param +"\"}");

        try {
		SendSmsResponse response = client.getAcsResponse(request);
		System.out.println(new Gson().toJson(response));
	} catch (ClientException e) {
		System.out.println("ErrCode:" + e.getErrCode());
		System.out.println("ErrMsg:" + e.getErrMsg());
		System.out.println("RequestId:" + e.getRequestId());
	}

	}
}
