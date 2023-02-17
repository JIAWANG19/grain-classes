/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.atcjw.result;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class RetJson {
	private int code;
	private String message;
	private Map<String, Object> data;

	 public static RetJson ok() {
		 RetJson retJson = new RetJson();
		 retJson.setCode(200);
		 retJson.setMessage("success");
		 return retJson;
	 }

	 public static RetJson fail(String message) {
		 RetJson retJson = new RetJson();
		 retJson.setCode(500);
		 retJson.setMessage(message);
		 return retJson;
	 }

	public static RetJson fail(int code, String message) {
		RetJson retJson = new RetJson();
		retJson.setCode(code);
		retJson.setMessage(message);
		return retJson;
	}

	 public RetJson put(String key, Object value) {
		 if (this.data == null) {
			 this.data = new HashMap<>();
		 }
		 this.data.put(key, value);
		 return this;
	 }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
