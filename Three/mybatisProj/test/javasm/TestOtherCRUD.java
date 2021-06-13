package javasm;

import com.javasm.entity.SysDept;
import com.javasm.entity.SysPermission;
import com.javasm.entity.SysRole;
import com.javasm.mapper.SysDeptMapper;
import com.javasm.mapper.SysPermissionMapper;
import com.javasm.mapper.SysRoleMapper;
import com.javasm.utils.SSF;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.List;

/**
 * @className: TestOtherCRUD
 * @description:   
 * @author SunHang
 * @createTime 2021/6/9 20:13
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestOtherCRUD {
    private static SqlSessionFactory ssf = null;
    private SqlSession session = null;
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

    }
    @After
    public void close(){
        session.close();
    }

    @Test
    public void test1_deptAdd(){
        SysDept sysDept = new SysDept();
        sysDept.setDeptName("测试");
        sysDept.setDeptPhone("88888888");
        sysDept.setDeptManagerId(1);
        sysDept.setDeptParentId(2);
        SysDeptMapper mapper = session.getMapper(SysDeptMapper.class);
        int i = mapper.addObj(sysDept);
        session.commit();
    }
    @Test
    public void test2_selectDeptById(){
        SysDeptMapper mapper = session.getMapper(SysDeptMapper.class);
        SysDept sysDept = mapper.selectById(1);
        System.out.println(sysDept);
    }
    @Test
    public void test3_selectDeptList(){
        SysDeptMapper mapper = session.getMapper(SysDeptMapper.class);
        List<SysDept> sysDepts = mapper.selectList();
        System.out.println(sysDepts);
    }
    @Test
    public void test4_selectListDeptUsers(){
        SysDeptMapper mapper = session.getMapper(SysDeptMapper.class);
        List<SysDept> sysDepts = mapper.selectListDeptUsers();
        System.out.println(sysDepts);
    }
//    ---------------------------------------
    @Test
    public void test4_selectListRolePermissions(){
        SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
        List<SysRole> sysRoles = mapper.selectListRolePermissions();
        System.out.println(sysRoles);
    }

    @Test
    public void test5_selectListRoleUsers(){
        SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
        List<SysRole> sysRoles = mapper.selectListRoleUsers();
        System.out.println(sysRoles);
    }

    @Test
    public void test5_setPermission(){
        SysRoleMapper mapper = session.getMapper(SysRoleMapper.class);
        Integer rid = 1;
        mapper.removePermissionByRoleId(1);
        Integer[] perids = new Integer[]{1,2,3,4,5};
        mapper.setPermisisons(rid,perids);
        session.commit();
    }

    @Test
    public void test6_selectPermissionByRoleId(){
        SysPermissionMapper mapper = session.getMapper(SysPermissionMapper.class);
        List<SysPermission> sysPermissions = mapper.selectPermissionByRoleId(1);
        System.out.println(sysPermissions);
    }
    @Test
    public void test6_selectLastNodePermissionByRoleId(){
        SysPermissionMapper mapper = session.getMapper(SysPermissionMapper.class);
        List<SysPermission> sysPermissions = mapper.selectLastNodePermissionByRoleId(1);
        System.out.println(sysPermissions);
    }
    @Test
    public void test7_selectUpPermission(){
        SysPermissionMapper mapper = session.getMapper(SysPermissionMapper.class);
        SysPermission sysPermission = mapper.selectUpPermission(3, 2);
        System.out.println(sysPermission);
    }
}
