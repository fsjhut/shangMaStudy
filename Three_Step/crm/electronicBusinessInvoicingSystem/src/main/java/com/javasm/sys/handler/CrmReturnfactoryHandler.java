package com.javasm.sys.handler;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.javasm.commons.bean.ReturnCrmReturnFactory;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.ServletUtil;
import com.javasm.sys.entity.CrmReturnfactory;
import com.javasm.sys.service.CrmReturnfactoryService;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("crmReturnfactory")
public class CrmReturnfactoryHandler extends BaseHandler {

    @Resource
    private CrmReturnfactoryService crmReturnfactoryService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        CrmReturnfactory obj = this.crmReturnfactoryService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectAll(CrmReturnfactory obj) {
        obj.setUname(CurrentLoginUser.getUname());
        startPage();
        List<CrmReturnfactory> list = this.crmReturnfactoryService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(String goodsCode,Integer refactoryState) {
        CrmReturnfactory obj = new CrmReturnfactory();
        obj.setReturnsId(goodsCode);
        obj.setRefactoryState(refactoryState);
        boolean r = this.crmReturnfactoryService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody CrmReturnfactory obj) {
        boolean r = this.crmReturnfactoryService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.crmReturnfactoryService.delByIds(Arrays.asList(split));
        return result(r);
    }

    @GetMapping("all")
    public AxiosResult queryAll(){

        List<ReturnCrmReturnFactory > goodsManagers = this.crmReturnfactoryService.queryAll();

        return suc(goodsManagers);
    }
    @PostMapping("out")
    public AxiosResult outfactory(){

        List<CrmReturnfactory> factorys = this.crmReturnfactoryService.selectList(new CrmReturnfactory());
        ArrayList<Object> list = CollUtil.newArrayList();
        for (CrmReturnfactory factory : factorys) {
            list.add(factory);
        }
        String uuid = IdUtil.simpleUUID();
        String path = "d:/"+uuid+"入库信息.xlsx";
        ExcelWriter writer = ExcelUtil.getWriter(path);
        writer.addHeaderAlias("refactoryCode","入库单号");
        writer.addHeaderAlias("refactoryFlag","入库标志");
        writer.addHeaderAlias("refactoryState","审批状态");
        writer.addHeaderAlias("returnsId","商品串码");
        writer.addHeaderAlias("createTime","创建时间");
        writer.addHeaderAlias("updateTime","更新时间");
        writer.addHeaderAlias("createBy","创建人");
        writer.addHeaderAlias("updateBy","更新人");
        writer.merge(9,"返厂入库详情信息");
        writer.write(list,true);
        writer.close();
        return suc(path);
    }
    @GetMapping("down")
    public ResponseEntity doFileDown(String path) throws IOException {
        String realPath = ServletUtil.getRequest().getServletContext().getRealPath("/");
        //D:\crm\electronicBusinessInvoicingSystem\target\electronicBusinessInvoicingSystem\
        File file = new File(realPath,path);
        String name = file.getName();
        System.out.println("文件名::"+name);//文件名
        byte[] bytes = FileUtils.readFileToByteArray(file);
        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename="+URLEncoder.encode(name,"UTF-8"));

        return new ResponseEntity(bytes,headers, HttpStatus.OK);
    }



}
















