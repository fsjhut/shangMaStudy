package com.javasm.sys.handler;

import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.sys.entity.Sysuser;
import com.javasm.sys.service.SysuserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("sysuser")
public class SysuserHandler extends BaseHandler {
    //可以移动到BaseHandler中
    private Logger l = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysuserService sysuserService;

    @PostMapping("loginByPwd")
    public AxiosResult loginByPwd(@RequestBody Sysuser u){
        //生产者消费者模式的应用.
        //多个线程生成数据到内存,多个线程消费消费从内存拿到数据保存到对应的文件中
        l.info(u.getUname()+"登录.");//同步代码,因为记录日志,io操作,需要耗时,效率降低

        Sysuser user = sysuserService.selectByUname(u.getUname());
        if(user==null) {
            throw new MvcException(S.NO_USER);
        }

        boolean isok = sysuserService.comparePwd(user.getUpwd(),u.getUpwd());
        if(!isok) {
            throw new MvcException(S.PWD_ERROR);
        }

        CurrentLoginUser.setLoginUser(user);
        user.setUpwd("");
        return suc(user);
    }

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Sysuser obj = this.sysuserService.selectById(id);
        return suc(obj);
    }
    //单查用户列表
    @GetMapping("list")
    public AxiosResult selectList(Sysuser obj) {
        startPage();
        List<Sysuser> list = this.sysuserService.selectList(obj);
        return toTableDatas(list);
    }

    //级联查询用户与部门数据
    @GetMapping("udlist")
    public AxiosResult selectUserAndDeptList(Sysuser obj) {
        startPage();
        List<Sysuser> list = this.sysuserService.selectUserAndDeptList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody Sysuser obj) {
        boolean r = this.sysuserService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody Sysuser obj) {
        boolean r = this.sysuserService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.sysuserService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
