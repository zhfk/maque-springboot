package com.zhfk.me.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(
        urlPatterns = "/druid/*",
        initParams = {
                @WebInitParam(name="allow",value = "0.0.0.0"),
                @WebInitParam(name="loginUsername",value = "admin"),
                @WebInitParam(name="loginPassword",value = "admin"),
                @WebInitParam(name = "restEnable",value = "false")
        }
)
public class DruidStatViewServlet extends StatViewServlet {
}
