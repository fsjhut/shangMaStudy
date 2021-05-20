package test.dao.impl;



import test.dao.UserDao;
import test.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    private String sql;
    @Override
    public List<User> getAllUser() throws Exception {
//        sql = "select uid,uname,uphone,uemail,uremark from tb_user ";
//        return queryList(sql);\
        return null;
    }

    @Override
    public boolean existsUsername(String userName) {
        sql = "select `phone` from tb_user where name = ?";
        User user = null;
        try {
            user = queryOne(sql, userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !(user==null);
    }

    @Override
    public int insertUser(User insertUser) throws SQLException {
        sql = "insert into tb_user(`name`,password,phone,email,gender,birth,img_src) VALUES (?,?,?,?,?,?)";
        return update(sql,insertUser.getName(),insertUser.getPassword(),insertUser.getPhone(),
                insertUser.getEmail(), insertUser.getGender(),insertUser.getBirth(),insertUser.getImageSrc());
    }

    @Override
    public User login(User loginUser) throws SQLException {
        String sql = "select `name`,phone,email,gender from tb_user" +
                "WHERE name = ? and password = ? ";
        return queryOne(sql, loginUser.getName(),loginUser.getPassword());
    }

    public Integer editUser(User user) throws SQLException {
        String sql = "update tb_user set `name`=?,password=?,phone=?,gender=?,email=?,prov_code=?" +
                "city_code=?, county_code=?,addr_detail=?,img_src=?,birth=?,desc=? WHERE id=?";
        return update(sql,user.getName(),user.getPassword(),user.getPhone(),user.getGender(),user.getEmail(),
                user.getProvCode(),user.getCityCode(),user.getCountyCode(),user.getAddrDetail(),user.getImageSrc(),
                user.getBirth(),user.getDesc(),user.getId());
    }
}
