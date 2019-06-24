package com.action.myboot.service.impl;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.action.myboot.mapper.InfoUserMapper;
import com.action.myboot.pojo.InfoUser;
import com.action.myboot.service.InfoUserService;
/**
 * 
 * @author Liuyf
 *测试redis的缓存
 */
@Service("infoUserService")
public class InfoUserServiceImpl implements InfoUserService {
	@Resource
	private InfoUserMapper infoMapper;
	@Override
	@Transactional
	//@Cacheable(value="redisCache",key="'redis_user'+#infoId")
	public InfoUser getInfoUser(int infoId) {
		// TODO Auto-generated method stub
		return infoMapper.getInfoUser(infoId);
	}
	
	@Override
	@Transactional
	@CachePut(value="redisCache",key="'redis_user'+#result.infoId")
	public InfoUser addInfoUser(InfoUser user) {
		  infoMapper.insertInfoUser(user);
		  return  user;
	}
	
	
	
	@Override
	@CachePut(value="redisCache",condition="#result != 'null'", key = "'redis_user'+#result.infoId")
	public InfoUser updateInfoUser(InfoUser user) {
		// TODO Auto-generated method stub
		 infoMapper.updateInfoUser(user);
		 return user;
	}
	@Override
	@Transactional
	@CacheEvict(value="redisCache",key="'redis_user'+#infoId",beforeInvocation=false)
	//移除缓存 在方法执行之后移除
	public int deleteInfoUser(int infoId) {
		// TODO Auto-generated method stub
		return infoMapper.deleteInfoUser(infoId);
	}
	@Override
	@Transactional
	//查询结果不准确
	public List<InfoUser> findUserLikeName(String userName) {
		// TODO Auto-generated method stub
		return infoMapper.findUserLikeName(userName);
	}

}
