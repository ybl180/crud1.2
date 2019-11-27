package com.sys.dao;

import com.sys.entity.PageBean;
import com.sys.entity.User;
import com.sys.utils.JdbctemplateUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author ybl
 * @version 1.0.1
 * @conpany 东风标准
 * @date 2019/11/26 17:33
 * @desciption
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbctemplateUtil.getDataSource());

    public List<User> findAll(String account, PageBean pageBean) {
        String sql = "select * from sys_user where account like ? limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class), "%" + account + "%",(pageBean.getPage()-1)*2,pageBean.getPageSize());
    }

    //查询信息的总数
    public Integer count(String account) {
        String sql = "select count(*) from sys_user where account like ?";
        return template.queryForObject(sql, Integer.class, "%" + account + "%");
    }

    public void deleteUser(Integer id) {
        String sql = "delete from sys_user where id=?";
        template.update(sql, id);
    }

    public void addUser(User user) {
        String sql = "insert into sys_user(account,name,age,sex,birth_date,create_time) values(?,?,?,?,?,?)";
        template.update(sql, user.getAccount(), user.getName(), user.getAge(), user.getSex(), user.getBirthDate(), user.getCreateTime());
    }

    public User getUserById(Integer id) {
        String sql = "select * from sys_user where id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    public void updateUser(User user) {
        String sql = "update sys_user set account=?,name=?,age=?,sex=?,birth_date=? where id=?";
        template.update(sql, user.getAccount(), user.getName(), user.getAge(), user.getSex(), user.getBirthDate(), user.getId());
    }
}
