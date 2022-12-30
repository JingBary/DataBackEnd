package com.jyh.control;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建Web应用过滤器，在过滤器里面的全是黑名单：并且启动类添加个注解：就能使用
 * @ServletComponentScan
 */
@WebFilter("/*")
public class MyFilter  implements Filter {
    private List<String> IPList=new ArrayList<>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { //过滤器初始化
        IPList.add("127.0.0.1"); // 本机地址
        IPList.add("0:0:0:0:0:0:0:1"); // IPv6 的本机地址,本机默认是这个地址
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, IOException {

        String ip = request.getRemoteAddr(); // 获得客户端 ip 地址
        System.out.println(ip); //控制台上查看一下
        if( IPList.contains(ip) ){
            response.setContentType("text/html;charset=utf-8"); //设置响应的字符集（避免中文乱码）
            response.getWriter().println("你已被列入黑名单!");
        }
        else{
            chain.doFilter(request,response); //放行
        }
    }
}

