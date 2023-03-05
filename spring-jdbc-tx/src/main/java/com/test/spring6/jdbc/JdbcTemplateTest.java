package com.test.spring6.jdbc;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpate() {
//        String sql = "insert into t_emp values(null, ?, ?, ?)";
//        Object[] params = {"洛必达", 22, "未知"};
//        int rows = jdbcTemplate.update(sql, params);
        // 增加
//        String sql = "insert into t_emp values(null, ?, ?, ?)";
//        int rows = jdbcTemplate.update(sql, "笛卡尔", 42, "未知");
//        System.out.println(rows);

        // 删除
        String sql = "delete from t_emp where id=?";
        int rows = jdbcTemplate.update(sql, 3);
        System.out.println(rows);


        // 修改
//        String sql2  = "update t_emp set name=? where id=?";
//        int result = jdbcTemplate.update(sql2, "笛卡尔坐标系", 3);
//        System.out.println(result);
    }

    // 查询
    @Test
    public void testSelectObject() {
        // 返回查询对象
        // 写法一：
        String sql = "select id, name, age, sex from  t_emp where id=?";
//        Emp empResult = jdbcTemplate.queryForObject(sql,
//                (rs, rowNum) -> {
//                    Emp emp = new Emp();
//                    emp.setId(rs.getInt("id"));
//                    emp.setName(rs.getString("name"));
//                    emp.setAge(rs.getInt("age"));
//                    emp.setSex(rs.getString("sex"));
//                    return emp;
//                }, 1);

        // 写法二
        Emp empResult = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println(empResult);
    }
    // 返回list集合
    @Test
    public void testSelectList() {
        String sql = "select * from t_emp";
        List<Emp> listquery = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(listquery);
    }

    // 返回单个值
    @Test
    public void testSelectCount() {
        String sql = "select count(id) from t_emp";
        Integer rows = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(rows);
    }



}
