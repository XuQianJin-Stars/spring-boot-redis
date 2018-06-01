package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.po.UserInfo;
import com.example.demo.service.CacheService;


@RestController
@RequestMapping(value="/user")
@Api("swaggerDemoController相关的api")
public class UserController {
	
	@Autowired
	private CacheService cacheService;

	/**
	 * 用户信息保存
	 * @param id
	 * @return
	 */
	@ApiOperation(value="用户信息保存", notes="用户详细信息保存")
	@RequestMapping(value = "user/save", method = RequestMethod.POST)
	@ResponseBody
	public String getUserById (@RequestBody UserInfo info){
		JSONObject json=new JSONObject();
		cacheService.setKey(info.getUserId(), JSONObject.toJSONString(info));
		return json.toJSONString();
	}

	/**
	 * 查询用户列表
	 * @return
	 */
	@ApiOperation(value="查询用户列表", notes="查询用户列表")
	@RequestMapping(value = "info/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getUserList (@PathVariable(value="id",required=true) String id){
		return JSONObject.toJSONString(cacheService.getKey(id));
	}
	
	
	/**
	 * 用户删除
	 * @return
	 */
	@ApiOperation(value="用户信息删除", notes="用户信息删除")
	@RequestMapping(value = "info/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String deleteUserInfo (@PathVariable(value="id",required=true) String id){
			cacheService.deleKey(id);
		return JSONObject.toJSONString("");
	}
}