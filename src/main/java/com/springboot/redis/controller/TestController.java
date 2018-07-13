package com.springboot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.redis.lock.DistributedLockHandler;
import com.springboot.redis.lock.Lock;

import io.swagger.annotations.ApiOperation;

@RestController
public class TestController {

	@Autowired
	DistributedLockHandler lock;

	@ApiOperation(value = "lock", notes = "lock测试")
	@PostMapping("/v1/base")
	public void testLock() {
		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					seckill();
				}
			}).start();
		}

	}
	int n = 500;
	 public void seckill() {
		 Lock lock1 = new Lock("test", "test-1");
	        // 返回锁的value值，供释放锁时候进行判断
		 boolean flag = lock.tryLock(lock1);
	        System.out.println(Thread.currentThread().getName() + "获得了锁" + flag);
	        System.out.println(--n);
	        lock.releaseLock(new Lock("test", "test-1"));
	    }

}
