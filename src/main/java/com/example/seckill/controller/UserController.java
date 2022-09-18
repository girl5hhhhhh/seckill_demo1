package com.example.seckill.controller;


import com.example.seckill.pojo.User;
import com.example.seckill.rabbitmq.MQSender;
import com.example.seckill.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author chunyan.li
 * @since 2022-04-06
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MQSender mqSender;

//    /**
//     * 用户信息(测试)
//     * @param user
//     * @return
//     */
//    @RequestMapping("/info")
//    @ResponseBody
//    public RespBean info (User user) {
//        return RespBean.success(user);
//    }
//
//    /**
//     * 测试发送RabbitMQ消息
//     */
//    @RequestMapping("/mq")
//    @ResponseBody
//    public void mq() {
//        mqSender.send("Hello");
//    }
//
//    /**
//     * Fanout模式
//     */
//    @RequestMapping("/mq/fanout")
//    @ResponseBody
//    public void mq01() {
//        mqSender.sendFanout("Hello");
//    }
//
//    /**
//     * Direct模式
//     */
//    @RequestMapping("/mq/direct01")
//    @ResponseBody
//    public void mq03() {
//        mqSender.send01("Hello,Red");
//    }
//    /**
//     * Direct模式
//     */
//    @RequestMapping("/mq/direct02")
//    @ResponseBody
//    public void mq04() {
//        mqSender.send02("Hello,Green");
//    }
//
//    /**
//     * 测试发送RabbitMQ消息
//     */
//    @RequestMapping("/mq/topic01")
//    @ResponseBody
//    public void mq05() {
//        mqSender.send03("Hello,Red");
//    }
//    /**
//     * 测试发送RabbitMQ消息
//     */
//    @RequestMapping("/mq/topic02")
//    @ResponseBody
//    public void mq06() {
//        mqSender.send04("Hello,Green");
//    }
//
//    /**
//     * 测试发送RabbitMQ消息
//     */
//    @RequestMapping("/mq/header01")
//    @ResponseBody
//    public void mq07() {
//        mqSender.send01("Hello,header01");
//    }
//    /**
//     * 测试发送RabbitMQ消息
//     */
//    @RequestMapping("/mq/header02")
//    @ResponseBody
//    public void mq08() {
//        mqSender.send02("Hello,header02");
//    }

}
