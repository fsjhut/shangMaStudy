package com.javasm.sys.handler;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.cache.RedisService;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.S;
import com.javasm.sys.entity.GoodType;
import com.javasm.sys.service.GoodTypeService;
import org.apache.commons.collections4.Put;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (GoodType)表控制层
 *
 * @author makejava
 * @since 2021-06-30 16:32:49
 */
@RestController
@RequestMapping("goodType")
public class GoodTypeHandler extends BaseHandler {
    /**
     * 服务对象
     */

    @Resource
    private GoodTypeService goodTypeService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        GoodType goodType = this.goodTypeService.selectById(id);
        return suc(goodType);
    }

    @GetMapping("list")
    public AxiosResult selectList(GoodType obj){
        startPage();
        List<GoodType> list = this.goodTypeService.selectList(obj);
        return toTableDatas(list);
    }

    @GetMapping("tree")
    public AxiosResult selectTree(GoodType obj){

        List<GoodType> list = this.goodTypeService.selectList(obj);
        List<GoodType> tree = this.goodTypeService.createTree(list);
        return suc(tree);
    }
    /**
     * 通过类型查询数据
     *
     * @param typeName 主键
     * @return
     */
    @GetMapping("selectByType/{typeName}")
    public AxiosResult selectByType(@PathVariable("typeName") String typeName) {
        startPage();
        List<GoodType> list = this.goodTypeService.selectByType(typeName);

        return toTableDatas(list);
    }
    @GetMapping("selectByType")
    public AxiosResult selectByType1() {
        startPage();
        List<GoodType> list = this.goodTypeService.selectByType(null);
        return toTableDatas(list);
    }

    @GetMapping("selectList/{id}")
    public AxiosResult selectList(@PathVariable("id") String  id) {

        GoodType goodType = this.goodTypeService.selectById(id);
        startPage();
        List<GoodType> list = goodTypeService.selectChild(goodType.getTid().toString());
        list.add(0,goodType);

        return toTableDatas(list);
    }

//
    @PostMapping
    public AxiosResult add(@RequestBody GoodType obj){
        boolean add = this.goodTypeService.add(obj);
        return result(add);
    }

    @PutMapping
    public AxiosResult updateById(@RequestBody GoodType obj){
        boolean b = this.goodTypeService.updateById(obj);
        return result(b);
    }

    @DeleteMapping("id/{id}")
    public AxiosResult delById(@PathVariable("id") String id){
        boolean hasChilds = goodTypeService.hasChilds(id);
        if(hasChilds)
            return error(S.ERROR);
        //执行删除
        List<String> ids = new ArrayList<>();
        ids.add(id);
        boolean r = this.goodTypeService.delById(id);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delByIds(@PathVariable("ids") String ids){
        String[] split = ids.split(",");
        boolean r = this.goodTypeService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
