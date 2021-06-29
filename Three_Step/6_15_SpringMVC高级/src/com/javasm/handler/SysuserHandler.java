package com.javasm.handler;

import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.S;
import com.javasm.commons.entity.TableDatas;
import com.javasm.commons.exception.MvcException;
import com.javasm.entity.Sysrole;
import com.javasm.entity.Sysuser;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController//当前类中所有的处理器方法返回值通知json消息转换器转json字符串返回前端
@RequestMapping("user")//url映射路径第一层
//@CrossOrigin(origins = "http://localhost:8088",allowedHeaders = "*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowCredentials ="true")
public class SysuserHandler {
    //user/100
    //axios.get("/user/100")
    @GetMapping("{uid}")//{}定义了路径变量,PathVariable是获取路径变量
    public AxiosResult queryById(@PathVariable("uid") Integer i){
            int a=1/0;
            System.out.println("查询用户,用户id:"+i);
            Sysuser u  =new Sysuser();
            u.setUid(i);
            u.setUname("xxxx");
        return AxiosResult.suc(u);
    }
    //{code:错误码,msg:""}

    //axios.post("/user",{})
    @PostMapping
    public AxiosResult addUser(@RequestBody Sysuser u){
        System.out.println("添加用户:"+u);
        return AxiosResult.suc();
    }

    //tomcat只对post请求的请求体k=v格式的数据进行解析.支持getParameter获取.
    //对put请求的k=v格式的数据,需要输入流获取解析.不支持getParameter
    //axios.put("/user",{})
    @PutMapping
    public AxiosResult updateUserById(Sysuser u){
        System.out.println("编辑用户:"+u);
        return AxiosResult.suc();
    }

    //axios.put("/user/name",{})
//    @PutMapping("name")
//    public AxiosResult updateUserByName(@RequestBody Sysuser u){
//        System.out.println("编辑用户:"+u);
//        return AxiosResult.suc();
//    }

    //axios.delete("/user/1,2,3,4")
    @DeleteMapping("{uids}")
    public AxiosResult delUser(@PathVariable("uids")String uids){
        System.out.println("删除用户:"+uids);
        String[] ids = uids.split(",");
        System.out.println(Arrays.toString(ids));
        return AxiosResult.suc();
    }




    //什么时候get请求|post请求?
    //post请求:参数基本都在请求体,axios提交的json格式,@RequestBody接收请求体的json数据
    //axios.post("http://localhost:8080/user/login?rid=1&rname=fyt",{uid:1,uname:fyt,upwd:123,uphone:12312312})
    //public AxiosResult login(Sysrole r, @RequestBody Sysuser u, HttpSession session)
    @PostMapping("login")
    public AxiosResult login(@RequestBody Sysuser u, HttpSession session){
        System.out.println("登录用户:"+u);

        if(u.getUname().equals("admin")&&"admin".equals(u.getUpwd())){
            session.setAttribute("loginuser",u);
            return AxiosResult.suc(u);
        }
        //return AxiosResult.error(S.PWD_ERROR)
        throw new MvcException(S.PWD_ERROR);
    }

    //get请求:参数都在url后追加?k=v&k=v
    //http://localhost:8080/user/list?uname=fyt&pageNum=2&pageSize=20
    @GetMapping("list")
    public AxiosResult getusers(Sysuser u,@RequestParam(defaultValue = "1")
            Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize){
        System.out.println("用户列表查询:"+u+",分页参数:"+pageNum+"-"+pageSize);
        List<Sysuser> us = new ArrayList<>();
        us.add(new Sysuser(1,"aaa","111111111","fythnu"));
        us.add(new Sysuser(2,"bbb","222222222","fythnu2"));
        us.add(new Sysuser(3,"ccc","333333333","fythnu3"));
        TableDatas datas = new TableDatas(us,pageNum,pageSize,100);
        return AxiosResult.suc(datas);
    }

}
