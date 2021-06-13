package javasm;

import com.javasm.entity.SysUser;
import com.javasm.mapper.SysUserMapper;
import com.javasm.utils.SSF;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: TestCRUD
 * @description:   
 * @author SunHang
 * @createTime 2021/6/7 19:29
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserCRUD {
    private static SqlSessionFactory ssf = null;
    private SqlSession session = null;
    private SysUserMapper mapper = null;
    @BeforeClass
    public static void beforeClass()
    {
        ssf= SSF.getFactory();
    }
    @AfterClass
    public static void afterClass(){
        ssf=null;
    }
    @Before
    public void init(){
        session= ssf.openSession();
        mapper = session.getMapper(SysUserMapper.class);
    }

    @After
    public void close(){
        session.close();
    }

    @Test
    public void test1_addUser(){
        SysUser u = new SysUser(2,"hhhhhh","333333");
        int i = mapper.addObj(u);
        System.out.println(i);
        session.commit();
        //set autocommit false
    }

    @Test
    public void test2_batchAddUser(){
        SysUser[] sysUsers = new SysUser[10];
        String pwd = "123456";
        for (int i = 0; i < 10; i++) {
            SysUser sysUser = new SysUser(1,"小明_" + i, pwd);
            sysUsers[i] = sysUser;
        }
        //受影响的行数
        int i = mapper.batchAddObjs(sysUsers);
        System.out.println(i);
        session.commit();
    }

    @Test
    public void test3_deleteUser() {
        mapper.delObj(20);
        session.commit();
    }

    @Test
    public void test4_batchDeleteUser(){
        List<Integer> deleteIds = new ArrayList<>();
        // 删除的开始id 10  如果给定了不存在的id则没有影响
        Integer startIndex = 10;
        for (int i = 0; i < 10; i++,startIndex++) {
            deleteIds.add(startIndex);
        }
        //受影响的行数
        int i = mapper.batchDelObjs(deleteIds);
        System.out.println(i);
        session.commit();
    }

    @Test
    public void test5_updateUser() {
        SysUser u = new SysUser();
        u.setUname("松松s");
        u.setUpwd("123456");
        // 设置需要修改的用户的id
        u.setUid(9);
        //受影响的行数
        int i = mapper.updateObj(u);
        System.out.println(i);
        session.commit();
    }

    @Test
    public void test6_selectUserByKey() {
        Integer selectId = 9;
        SysUser sysUser = mapper.selectById(selectId);
        System.out.println(sysUser);
    }

    @Test
    public void test7_selectListUser() {
        List<SysUser> sysUsers = mapper.selectList();
        System.out.println(sysUsers);
    }

    // 进行多表联合查询
    @Test
    public void test8_selectOneObjAndObj(){
        SysUser sysUser = mapper.selectOneObjAndObj(2);
        System.out.println(sysUser);
    }

    @Test
    public void test8_selectListObjAndObj(){
        List<SysUser> sysUsers = mapper.selectListObjAndObj();
        System.out.println(sysUsers);
    }
    //查询单个用户所拥有的权限
    @Test
    public void test9_selectOnePermissions(){
        SysUser sysUser = mapper.selectOnePermissions(2);
        System.out.println(sysUser);
    }

    //查询所有用户所拥有的权限
    @Test
    public void test10_selectListPermissions(){
        List<SysUser> sysUsers = mapper.selectListPermissions();
        System.out.println(sysUsers);
    }
    // 进行高级搜索查询
    @Test
    public void test9_selectListByParams(){
        // 接受到的参数是一个map<String,string>集合
        Map<String,String> params = new HashMap<>();
        params.put("deptId","2");
        params.put("userGender","3");
        List<SysUser> sysUsers = mapper.selectListByParams(params);
        System.out.println(sysUsers);
    }
}
