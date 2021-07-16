package com.javasm.sys.handler;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.S;
import com.javasm.sys.entity.Ver;
import com.javasm.sys.service.VerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("ver")
public class VerHandler extends BaseHandler {

    @Resource
    private VerService verService;


    /**
     * @param obj: 需要传入verifyTableId（指定源数据表名）
     *             verifyTableId（审核记录中存储的ID）
     * @Description:
     * @return: com.javasm.commons.entity.AxiosResult
     **/

    @GetMapping("list")
    public AxiosResult selectList(Ver obj) {
//        startPage();
        List<Ver> list = this.verService.selectList(obj);
        return new AxiosResult(S.SUC, list);
    }

//    @PostMapping
//    public AxiosResult add(@RequestBody Map map) {
//        CrmSysuser user = CurrentLoginUser.getLoginUser();
//        String uname = user.getUname();
//
//
//        //  审核状态码为0时候，则当前为 申请的创建人的  创建/修改 操作，设置 applicant（申请人） 字段为当前登录ID
//        if (obj.getVerifyStatus() == 0) {
//            obj.setApplicant(uname);
//            if ("".equals(obj.getVerifyTime()) && obj.getVerifyTime() == null) {
//                obj.setVerifyTime(DateUtil.getYMDHMS());
//            }
//
//
//        } else if (obj.getVerifyStatus() == 1 && user.getUid() == 2 && "goods_price_adjustment".equals(obj.getVerifyTable())) {
//            obj.setVerifyPerson(uname);
//            obj.setApplicant(uname);
//            obj.setVerifyTime(DateUtil.getYMDHMS());
//        }
//        //  审核状态码 非0 时候：即对审核状态进行 1/2 的状态修改，修改 verify_person （审核人） 字段为当前登录用户的ID
//        else {
//            obj.setVerifyPerson(uname);
//            obj.setVerifyTime(DateUtil.getYMDHMS());
//
//        }
//        boolean r = this.verService.add(obj);
//        return result(r);
//    }

    @PostMapping("adds")
    public AxiosResult adds(@RequestBody Map map) throws Exception {
        boolean adds = verService.adds(map);
        if (adds) return suc();
        return error();
    }


    @PostMapping("auditMultistage")
    public AxiosResult auditMultistage(@RequestBody Map map) throws Exception {

        boolean adds = verService.auditMultistage(map);
        if (adds) return suc();
        return error();
    }


}

