package com.javasm.sys.handler;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.cache.RedisService;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.S;
import com.javasm.sys.entity.GoodType;
import com.javasm.sys.service.GoodTypeService;
import org.apache.commons.collections4.Put;
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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id")String id) {
        GoodType goodType = this.goodTypeService.selectById(id);

        return suc(goodType);
    }

    @GetMapping("list")
    public AxiosResult selectList(GoodType obj){
        startPage();
        List<GoodType> list = this.goodTypeService.selectList(obj);
        List<GoodType> tree = this.goodTypeService.createTree(list);
        return suc(tree);
    }


    @PostMapping("add")
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
    public AxiosResult deleteById(@PathVariable("id") String id){
        boolean hasChilds = goodTypeService.hasChilds(id);
        if(hasChilds)
            return error(S.ERROR);

        //执行删除
        List<String> ids = new ArrayList<>();
        ids.add(id);
        boolean r = this.goodTypeService.delByIds(ids);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult deleteByIds(@PathVariable("ids") String ids){

        String[] split = ids.split(",");
        boolean r = this.goodTypeService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
