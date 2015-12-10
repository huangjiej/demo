/**
 * 
 */
package com.hummingbird.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.ValidateResult;
import com.hummingbird.commonbiz.vo.AppVO;
import com.hummingbird.demo.entity.Appinfo;
import com.hummingbird.demo.mapper.AppinfoMapper;
import com.hummingbird.demo.services.AppInfoService;

/**
 * 应用service
 * @author huangjiej_2
 * 2014年11月11日 下午12:59:47
 */
@Service
public class AppInfoServiceImpl implements AppInfoService {
	
	@Autowired
	AppinfoMapper appdao;
	
	
	/**
	 * 获取app
	 * @param appId
	 * @return
	 */
	@Override
	public Appinfo getAppByAppid(String appId){
		return appdao.selectByPrimaryKey(appId);
	}


	/**
	 * 校验app网站信息
	 * @param appvo
	 * @return
	 * @throws ValidateException
	 */
	@Override
	public ValidateResult validate(AppVO appvo) throws DataInvalidException {
		ValidateResult vr = new ValidateResult();
		ValidateUtil.assertNull(appvo.getAppId(), "appId为空",ValidateException.ERROR_EXISTING_APP_NOT_EXISTS.getErrcode());
		Appinfo app = getAppByAppid(appvo.getAppId());
		ValidateUtil.assertNull(app, "APP不存在",ValidateException.ERROR_EXISTING_APP_NOT_EXISTS.getErrcode());
		if(!"OK#".equals(app.getStatus())){
			throw ValidateException.ERROR_APP_OFFLINE;
		}
//		appvo.setAppKey(app.getAppKey());
//		appvo.setAppname(app.getAppname());
		vr.setValidateObj(app);
		return vr;
	}


	/* (non-Javadoc)
	 * @see com.hummingbird.maaccount.service.AppInfoService#getPublicKeyStr(java.lang.String)
	 */
	@Override
	public String getPublicKeyStr(String appId) {
		throw new RuntimeException("此appinfo没有此方法");
//		AppInfo app = appdao.selectByPrimaryKey(appId);
//		if(app!=null){
//			String appPublicKey = app.getAppPublicKey();
//			if(appPublicKey!=null){
//				appPublicKey=appPublicKey.replace("-----BEGIN CERTIFICATE-----", "").replace("-----END CERTIFICATE-----"	,"");
//				return appPublicKey;
//			}
//		}
//		return null;
	}
	
	
}
