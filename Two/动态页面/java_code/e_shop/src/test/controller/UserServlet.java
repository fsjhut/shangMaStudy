package test.controller;

import com.alibaba.fastjson.JSON;
import test.entity.ReturnCode;
import test.entity.ReturnEntity;
import test.entity.User;
import test.service.UserService;
import test.service.impl.UserServiceImpl;
import test.utils.MD5Util;
import test.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author SunHang
 * @className: RegisterServlet
 * @description:
 * @createTime 2021/5/19 17:55
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService userService= new UserServiceImpl();
    /**
     * 用户注销方法
     */
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 移除Session对象中的用户信息
        req.getSession().removeAttribute("user");
        // 然后重定向到登录页面。或首页
        resp.sendRedirect(req.getContextPath());
    }
    // 用户注册时判断用户名是否存在
    public void regName(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException {
        // 获取用户名
        String username = req.getParameter("username");
        ReturnEntity re = new ReturnEntity();
        String returnStr;
        // 用户名不能为空
        if (userService.existsUsername(username)) {
            //拼接json格式给前端
            re.setCode(ReturnCode.NAME_DUP.getCode());
            re.setReturnMsg(ReturnCode.NAME_DUP.getMsg());
            re.setReturnData("red");
        } else {
            re.setCode(ReturnCode.NAME_OK.getCode());
            re.setReturnMsg(ReturnCode.NAME_OK.getMsg());
            re.setReturnData("green");
        }
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //使用工具 把需要返回的数据 转成json格式字符串
        returnStr = JSON.toJSONString(re);
        writer.print(returnStr);
        writer.flush();
        writer.close();
    }

    /**
     * 注册用户的操作
     *
     * @param
     * @param
     * @throws IOException
     * @throws ServletException
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException {
        // 把传递过来的参数赋值到user对象中
        User user = new User();
//        Utils.copyMap2Bean(req.getParameterMap(), user);
        // 判断用户名是否已经存在！
        ReturnEntity re = new ReturnEntity();
        if (userService.existsUsername(user.getName())) {
            // 用户名已存在
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        } else {
            // 注册用户信息
            // 如果返回true说明注册成功
            if (userService.insertUser(user) == 1) {
                // 如果注册成功。跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            } else {
                System.out.println("用户注册失败");
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            }
        }
    }

    /**
     * 登录的操作
     *
     * @param
     * @param
     * @throws IOException
     * @throws ServletException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException {

        User user = new User();
        System.out.println("11111111111111");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        // 进行密码的加密操作
        String newPassword = MD5Util.md5EncodeUtf8(password);
        user.setName(name);
        user.setPassword(newPassword);
        System.out.println("进入login中");
        // 根据用户名密码根据系统
        User selectUser = userService.login(user);
        // 如果user不为null，说明登录成功！
        if (selectUser != null) {
            // 把用户添加到Session对象中
            req.getSession().setAttribute("loginUser", user);
            System.out.println("[" + user.getName() + "]用户登录成功！跳转去登录成功页面login_success.jsp");
            // 登录成功之后。转发到登录成功 页面
            req.getRequestDispatcher("/pages/goodsPage.html").forward(req, resp);
        } else {
            // 如果user == null ,说明登录失败，用户名错误，或者密码错误。
            req.setAttribute("msg", "登录失败，用户名或密码错误！");
            req.setAttribute("username", user.getName());
            System.out.println("[" + user.getName() + "]用户登录失败！跳转去登录页面login.jsp");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }
}
