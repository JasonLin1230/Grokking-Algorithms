package com.jedis;

import org.junit.jupiter.api.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis����
 * @author Administrator
 *
 */
public class JedisDemo1 {

	@Test
	/**
	 * ��������
	 */
	public void demo1(){
		//����IP�Ͷ˿�
		Jedis jedis = new Jedis("47.94.132.248",6379);
		//��������
		jedis.set("name", "JasonLin");
		//��ȡ����
		String value = jedis.get("name");
		System.out.println(value);
		//�ͷ���Դ
		jedis.close();
	}
	@Test
	/**
	 * ���ӳز���
	 */
	public void demo2(){
		//������ӳ����ö���
		JedisPoolConfig config = new JedisPoolConfig();
		//�������������
		config.setMaxTotal(30);
		//����������������
		config.setMaxIdle(10);
		//������ӳ�
		JedisPool jedisPool = new JedisPool(config,"47.94.132.248",6379);
		
		//��ú��Ķ���
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set("name","JasonLin");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			if(jedis != null) {
				jedis.close();
			}
			if(jedisPool != null) {
				jedisPool.close();
			}
		}
	}
}
