package com.Luhuihuang.week5.demo;


import com.Luhuihuang.dao.UserDao;
import com.Luhuihuang.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/login")
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        Connection con = null;
        public void init () throws SecurityException, ServletException {
            super.init();
//        ServletContext context=getServletContext();
//        String driver=context.getInitParameter("driver");
//        String url=context.getInitParameter("url");
//        String username=context.getInitParameter("username");
//        String password=context.getInitParameter("password");
//        try {
//            Class.forName(driver);
//            con= DriverManager.getConnection(url,username,password);
//            System.out.println("Connection --> in JDBCDemoServlet"+con);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
            con = (Connection) getServletContext().getAttribute("con");

            //TODO 1: GET 4 CONTEXT PARAM - DRIVER , URL,USERNAME , PASSWORD
        /*ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");*/


            //TODO 2: GET JDBC connection
        /*try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in JDBCDemoServlet"+con);//just print for test
            //one connection -
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
            con = (Connection) getServletContext().getAttribute("con");
        }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

            System.out.println("Connection --> " + con);
            //System.out.println("login serlvet doGet");
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
        }
        @Override

        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            PrintWriter writer = response.getWriter();
            try {
                String sql = "select * from usertable where username=? and password=?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    //writer.println("<h1>Login Success!!!</h1>");
                    //writer.println("<h1>Welcome" + username + "</h1>");
                    System.out.println("login servlet dopost");
                    //PrintWriter writer = response.getWriter();

                    request.setAttribute("id", resultSet.getInt("id"));
                    request.setAttribute("username", resultSet.getString("username"));
                    request.setAttribute("password", resultSet.getString("password"));
                    request.setAttribute("email", resultSet.getString("email"));
                    request.setAttribute("gender", resultSet.getString("gender"));
                    request.setAttribute("birthDate", resultSet.getString("birthDate"));
                    //TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSEORD from login
                    String username = request.getParameter("username");//name of input type
                    String password = request.getParameter("password");
                    System.out.println(username);
                    System.out.println(password);

                    request.getRequestDispatcher("userInfo.jsp").forward(request, response);

                } else {
                    //writer.println("<h1>Login Error!!!</h1>");
                    request.setAttribute("message", "Username or password Error!!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    UserDao userDao = new UserDao();
                    try {
                        User user = userDao.findByUsernamePassword(con, username, password);
                        if (user != null) {
                            request.setAttribute("user", user);
                            request.getRequestDispatcher("WEB-INF/views/userList.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message", "Username or Password Eorror!!!");
                            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                    // TODO 4:VALIDATE USER - SELECT * FROM USERTABLE WHERE USERNAME='XXX' AND PASSWORD='YYY'
       /* try {
           // String sql = "Select * from usertable where username=? and password=? ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            //5
            if(resultSet.next()){
                //writer.println("<br/> <h1>Login Success!!!</h1><br/>");
                //writer.println("<h1> Welcome "+username+" </h1>");
                request.setAttribute("id",resultSet.getInt("id"));
                request.setAttribute("username",resultSet.getString("username"));
                request.setAttribute("password",resultSet.getString("password"));
                request.setAttribute("email",resultSet.getString("email"));
                request.setAttribute("gender",resultSet.getString("gender"));
                request.setAttribute("birth date",resultSet.getString("birthDate"));
                request.getRequestDispatcher("userList.jsp").forward(request,response);
            }else {
                //writer.println("<h1>Username or Password Error!!!</h1>");
            //writer.close();
                request.setAttribute("message","Username or Password Eorror!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    } catch (SQLException e) {
            e.printStackTrace();
        }*/
                }
                public void destroy () {
                    super.destroy();
                    //close connection here - when stop tomcat
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
