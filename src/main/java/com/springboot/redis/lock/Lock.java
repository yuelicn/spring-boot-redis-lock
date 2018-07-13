package com.springboot.redis.lock;

/**
 * 全局锁
 * 
 * @author yueli
 * @date: 2018年7月12日 下午2:16:27
 */
public class Lock {

	private String name;

	private String value;

	public Lock(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
