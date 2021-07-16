package com.javasm.sys.handler;



import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.cache.RedisService;
import com.javasm.commons.cache.VindicteMainTainDatas;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.DateUtil;
import com.javasm.sys.entity.CrmArea;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.entity.MaintainManager;
import com.javasm.sys.service.MaintainManagerService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.*;

@RestController
@RequestMapping("maintainManager")
public class MaintainManagerHandler extends BaseHandler {

    @Resource
    private MaintainManagerService maintainManagerService;
    @Resource
    private RedisService rs;
    @Resource
    private VindicteMainTainDatas mainTain;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        MaintainManager obj = this.maintainManagerService.selectById(id);
        return suc(obj);
    }
    @GetMapping("city")
    public AxiosResult getCity() {
        List<CrmArea> crmAreas =null;
        String allMainTainArea = rs.get("AllMainTainArea");
        if (allMainTainArea==null){
            crmAreas= mainTain.addRedisMainTain(null);
            return suc(crmAreas);
        }else{

            Object parse = JSON.parse(allMainTainArea);
            return suc(parse);
        }

    }

    @GetMapping("list")
    public AxiosResult selectList(MaintainManager obj) {
        startPage();
        List<MaintainManager> list = this.maintainManagerService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody MaintainManager obj) {
        obj.setCreateBy(CurrentLoginUser.getUname());
        boolean r = this.maintainManagerService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody MaintainManager obj) {
        boolean r = this.maintainManagerService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.maintainManagerService.delByIds(Arrays.asList(split));
        return result(r);
    }



    @PostMapping("uploadDatas")
    public AxiosResult doUploadFile(MultipartFile myfile, HttpServletRequest  req) throws IOException {
        byte[] bytes = myfile.getBytes();//文件内容,字节数据,适合小文件
        InputStream inputStream = myfile.getInputStream();//文件内容,输入流,适合大文件,没啥用
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<MaintainManager> maintainManagers = reader.readAll(MaintainManager.class);
        int saves = maintainManagerService.saves(maintainManagers);
        if (saves==0) return error();
        return suc(saves);
    }

    @PostMapping("load")
    public AxiosResult educe(MaintainManager obj){
        List<MaintainManager> list = maintainManagerService.selectList(obj);
        String fileName = UUID.randomUUID()+".xlsx";
        String path ="E:\\java_data\\"+fileName;
        ExcelWriter writer = ExcelUtil.getWriter("E:\\java_data\\"+fileName);
        writer.passCurrentRow();
        writer.write(list, true);
        writer.close();


        return suc(path);

    }


}
