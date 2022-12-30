package com.jyh.control;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 编写控制层的几种实现方法：
 * 1、无注解传入参数
 * 2、HttpServletRequest的getParameter方法
 * 3、@RequestParam
 * 4、PathVariable
 *
 *
 * 具体学习：
 * https://blog.csdn.net/weixin_45750972/article/details/117114619
 */
@RestController
public class ControllerLearningTest {
//    1、无注解传入参数：并返回
    @RequestMapping("/noparameter")
    public String Hello(String name){
        return name;
    }

    //2、HttpServletRequest的getParameter方法
    //访问网站：http://localhost:8089/HttpServletRequest?id=2
    @RequestMapping("/HttpServletRequest")
    public String test2( HttpServletRequest request ) {
        Integer id = Integer.parseInt( request.getParameter("id") ); // 转换一下(没有判断空串或null)
        return String.valueOf(id);
    }

    //3、@RequestParam
    @RequestMapping("/requestparam")
    //访问：http://localhost:8089/requestparam?stu_name=%22jyh%22
    public String test4(@RequestParam(value="stu_name",required=true,defaultValue = "何浩") String name) {
        return name;
    }

    //4、PathVariable
    @RequestMapping("/pathvariable/{name}")
    public String test5(@PathVariable(value = "name") String name) {
        return name;
    }

    //5、黑名单

}
