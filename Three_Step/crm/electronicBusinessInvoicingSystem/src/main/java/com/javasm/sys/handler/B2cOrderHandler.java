package com.javasm.sys.handler;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.sys.entity.B2cOrder;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.service.B2cOrderService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.*;

@RestController
@RequestMapping("b2cOrder")
public class B2cOrderHandler extends BaseHandler {

    @Resource
    private B2cOrderService b2cOrderService;

//    @GetMapping("{id}")
//    public AxiosResult selectById(@PathVariable("id") String id) {
//        B2cOrder obj = this.b2cOrderService.selectById(id);
//        return suc(obj);
//    }

    @GetMapping("list")
    public AxiosResult selectList(B2cOrder obj) {
        startPage();
        List<B2cOrder> list = this.b2cOrderService.selectList(obj);
        return toTableDatas(list);
    }

    @GetMapping("{orderId}")
    public AxiosResult selectOrderDetailById(@PathVariable("orderId") String oderId) {
        Map<String, Object> stringObjectMap = this.b2cOrderService.selectOrderDetailById(oderId);
        return suc(stringObjectMap);
    }

    @PostMapping
    public AxiosResult add(@RequestBody B2cOrder obj) {
        boolean r = this.b2cOrderService.add(obj);
        return result(r);
    }



    @GetMapping("down")
    public ResponseEntity doDownload(String path, HttpServletRequest req) throws Exception {
        String realPath = req.getServletContext().getRealPath("/");
        File f = new File(realPath, path);
        String filename = f.getName();
        byte[] bytes = FileUtils.readFileToByteArray(f);
        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));

        return new ResponseEntity(bytes, headers, HttpStatus.OK);
    }

    @PostMapping("educe")
    public AxiosResult educe(@RequestBody B2cOrder obj) {
        List<B2cOrder> list = this.b2cOrderService.selectList(obj);

        ExcelWriter writer = ExcelUtil.getWriter("E:/down.xlsx");
        writer.passCurrentRow();
//        writer.merge(list.size() - 1, "测试标题");
        writer.write(list, true);
        writer.close();
        return suc();
    }

    @PutMapping
    public AxiosResult update(@RequestBody B2cOrder obj) {
        boolean r = this.b2cOrderService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.b2cOrderService.delByIds(Arrays.asList(split));
        return result(r);
    }
    @PostMapping("insertB2C")
    public AxiosResult insertB2C(MultipartFile myfile, HttpServletRequest req) throws Exception {
        byte[] bytes = myfile.getBytes();//文件内容,字节数据,适合小文件
        String originalFilename = myfile.getOriginalFilename();//文件名
        long size = myfile.getSize();//文件大小
        //存文件
        String realPath = req.getServletContext().getRealPath("/");
        String path = "/upload/" + originalFilename;
        //原生输出流写数据的过程
        IOUtils.write(bytes, new FileOutputStream(new File(realPath, path)));
        Map<String, Object> result = new HashMap<>();
        result.put("path", path);
        result.put("realName", originalFilename);
        result.put("uploadTime", System.currentTimeMillis());
        result.put("size", size);

        ExcelReader reader = ExcelUtil.getReader("E:/B2C.xlsx");
        List<B2cOrder> all = reader.readAll(B2cOrder.class);
        Set<B2cOrder>set=new HashSet<>();
        set.addAll(all);

        List<B2cOrder> list = b2cOrderService.selectList(null);
        set.removeAll(list);
        System.out.println("set------->==="+set);
        List<B2cOrder>list1=new ArrayList<>();
        list1.addAll(set);
        if(list1.size()>0){
            int i1 = b2cOrderService.insertB2C(list1);
            if (i1> 0){ return result(true);}
        }
        return result(false);
    }

}
