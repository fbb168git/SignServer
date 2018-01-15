package com.fbb.sign.servlet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fbb.sign.VertifyUtil;
import com.fbb.sign.servlet.base.BaseServlet;

public class SignServlet extends BaseServlet {
    private static Logger logger = LoggerFactory.getLogger(SignServlet.class);

    @Override
    protected String process(HttpServletRequest request, HttpServletResponse response) {
        String content = request.getParameter("c");
        if(content!= null && !content.equalsIgnoreCase("")){
            logger.info("content:"+content);
            String sign = VertifyUtil.getValueFromAndroid(content);
            logger.info("sign:"+sign);
            return sign;
        }
        return null;
    }
}
