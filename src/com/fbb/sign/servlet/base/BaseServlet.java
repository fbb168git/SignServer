package com.fbb.sign.servlet.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

    protected static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String data = process(request, response);
        if(data != null && !data.equalsIgnoreCase("")){
            PrintWriter pw = response.getWriter();
            pw.print(data);
            pw.close();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


    /**
     * token检测
     * 
     * @param userPhone
     * @param token
     * @return
     */
    // protected boolean tokenChecked(String userPhone,String token){
    // TokenDaoImp tokenmodel=new TokenDaoImp();
    // boolean tokenUserful=tokenmodel.tokenChecked(userPhone, token);
    // return tokenUserful;
    // }

    /**
     * token失效返回
     * 
     * @return
     */
    protected Map<String, String> getJsonMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", "fail");
        map.put("data", "token error");
        return map;
    }

    protected abstract String process(HttpServletRequest request, HttpServletResponse response);

}
