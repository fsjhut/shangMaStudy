package com.javasm.commons.docx;

import com.javasm.sys.entity.Gift;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: JAVASM
 * @className: docUtil
 * @date: 2021/6/30 22:04
 * @version: 8.8.8
 * @since:6.6.6
 */
public class docUtil {
        public static void main(String[] args) {
            String target="E:/赠品转商品草稿.doc";
            Map<String,Object> map=new HashMap<>();
            List<Gift> list=new ArrayList<>();
            Writer out=null;
            try {
                out=new FileWriter(target);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
            configuration.setDefaultEncoding("UTF-8");
            configuration.setClassForTemplateLoading(docUtil.class,"/templates");
            try {
                Template template = configuration.getTemplate("赠品转商品草稿.xml");
                Gift gift = new Gift();
                gift.setGiftName("sss");
                gift.setGiftType("sss");
                gift.setGiftTyprice(23.0);
                gift.setGiftModel("ssss");
                gift.setGiftPrice(25.0);
                gift.setGiftCost(12.3);
//                gift.setGoodsStorage(50);
                gift.setGiftDepartment("ssss");
                gift.setGiftInventory(55);
                gift.setGiftColor("sss");

                list.add(gift);
                map.put("gift",list);
                template.process( map,out);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

