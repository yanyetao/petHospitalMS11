package com.yyt.web;

import com.yyt.mapper.UserMapper;
import com.yyt.pojo.User;
import com.yyt.utiL.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //        String resource = "mybatis-config.xml";
        //        InputStream inputStream = Resources.getResourceAsStream(resource);
        //        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        User user = userMapper.select(username,password);

        sqlSession.close();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (user==null){
            //登录失败
            writer.write("登录失败");
        }else {
            //登录成功
            writer.write("登录成功");
        }
        System.out.println("c");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
