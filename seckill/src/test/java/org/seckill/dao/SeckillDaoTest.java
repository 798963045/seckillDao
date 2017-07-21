package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hao on 2017/7/21.
 */

/**
 * 配置spring 和junit整合，junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;



    @Test
    public void queryById() throws Exception {
        long id=1000;
        Seckill seckill =seckillDao.queryById(id);
        System.out.print(seckill.getName());
        System.out.print(seckill);
    }

    /**
     *
     * 1000元秒杀iphone6
     * Seckill{
     * seckillId=1000,
     * name='1000元秒杀iphone6',
     * number=100,
     * startTime=Sun Nov 01 00:00:00 CST 2015,
     * endTime=Mon Nov 02 00:00:00 CST 2015,
     * createTime=Fri Jul 21 14:52:03 CST 2017
     */
    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills=seckillDao.queryAll(0,100);
        for (Seckill seckill:seckills) {
            System.out.print(seckill);

        }
    }

    /**
     * Seckill{seckillId=1000, name='1000元秒杀iphone6', number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Jul 21 14:52:03 CST 2017}Seckill{seckillId=1001, name='500元秒杀ipad2', number=200, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Jul 21 14:52:03 CST 2017}Seckill{seckillId=1002, name='300元秒杀小米4', number=300, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Jul 21 14:52:03 CST 2017}Seckill{seckillId=1003, name='200元秒杀红米note', number=400, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Jul 21 14:52:03 CST 2017}
     * @throws Exception
     */
    @Test
    public void reduceNumber() throws Exception {
        Date killTime=new Date();
        int updateCount=seckillDao.reduceNumber(1000L,killTime);
        System.out.print("updateCount = "+updateCount);
    }
}