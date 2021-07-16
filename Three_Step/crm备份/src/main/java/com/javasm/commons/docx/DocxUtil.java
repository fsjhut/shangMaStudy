package com.javasm.commons.docx;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocxUtil {
    public static void createDocx(String templateName,Object data,Writer out){
        Configuration config = new Configuration(Configuration.VERSION_2_3_23);
        config.setDefaultEncoding("UTF-8");//xml模板中的中文支持
        config.setClassForTemplateLoading(DocxUtil.class,"/templates");
        try {
            Template template = config.getTemplate(templateName,"UTF-8");
            template.process(data,out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        String target="D:/入职合同.doc";
        Writer out = new FileWriter(target);

//        Map<String,Object> data = new HashMap<>();
        Map<String,Object> alldata = new HashMap<>();
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("sort","1");
        map.put("product_code","10010");
        map.put("product_name","三星手机");
        map.put("product_num","100");
        map.put("product_price","1000");
        map.put("all_money","100000");
        map.put("market","三星note7");

        Map<String,Object> map2 = new HashMap<>();
        map2.put("sort","2");
        map2.put("product_code","10020");
        map2.put("product_name","小米手机");
        map2.put("product_num","10");
        map2.put("product_price","1000");
        map2.put("all_money","10000");
        map2.put("market","为发烧而生");
        data.add(map);
        data.add(map2);
        alldata.put("data",data);

//        List<> list = new ArrayList<>();
//        list.add(new Schools("河南省外国语中学","2009-9-1","2021-9-1","我问问"));
//        list.add(new Schools("XXX大学","2021-9-1","2023-9-1","看就"));
//        data.put("jyjl",list);

        createDocx("出库单模板.xml",alldata,out);
    }
}
