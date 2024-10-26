package com.atguigu;

import com.atguigu.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.ResultSet;
import java.util.List;

/**
 * Description:
 *
 * @Author: ylqi007
 * @Create: 10/26/24 10:15
 */
@SpringJUnitConfig(locations = "classpath:beans.xml")
class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加，修改，删除
    @Test
    public void test01() {

        // 01. 添加
        // 编写SQL语句
        String sql = "INSERT INTO t_emp VALUES(NULL, ?, ?, ?)";

        // 调用jdbctemplate方法
        // jdbcTemplate.update(sql, "东方不败", 20, "未知");
//        Object[] params = {"东方不败", 20, "未知"};
//        Object[] params = {"岳不群", 20, "未知"};
        Object[] params = {"林平之", 20, "未知"};
        int rows = jdbcTemplate.update(sql, params);
        System.out.println("Impacted rows: " + rows);
    }

    // 02. 修改
    @Test
    public void test02() {
        // 编写SQL语句
        String sql = "UPDATE t_emp SET age=? WHERE id=?";

        // 调用jdbctemplate方法
        // Object[] params = {40, 2};
        // int rows = jdbcTemplate.update(sql, params);
        int rows = jdbcTemplate.update(sql, 50, 2);
        System.out.println("Impacted rows: " + rows);
    }

    // 03. 删除
    @Test
    public void test03() {
        // 编写SQL语句
        String sql = "DELETE FROM t_emp WHERE id=?";

        // 调用jdbctemplate方法
        int rows = jdbcTemplate.update(sql, 3);
        System.out.println("Impacted rows: " + rows);
    }

    /**
     * 查询操作
     *  1. 返回一个对象
     *  2. 返回一个list集合
     *  3. 返回单个值
     */
    // 1. 返回一个对象
    @Test
    public void test04() {
        String sql = "SELECT * FROM t_emp WHERE id=?";

        // 写法一，可实现目标，但是写法麻烦繁琐
        // jdbcTemplate.queryForObject(sql, RowMapper, 1);
//        Emp emp1 = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
//            Emp emp = new Emp();
//            emp.setId(rs.getInt("id"));
//            emp.setName(rs.getString("name"));
//            emp.setAge(rs.getInt("age"));
//            emp.setSex(rs.getString("sex"));
//            return emp;
//        }, 1);
//        System.out.println("emp1 = " + emp1);

        // 写法二，
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println("Method 2: emp=" + emp);
    }

    // 2. 返回一个list集合
    @Test
    public void test05() {
        String sql = "SELECT * FROM t_emp";

        List<Emp> empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println("empList = " + empList);
    }

    // 3. 返回单个值
    @Test
    public void test06() {
        String sql = "SELECT COUNT(*) FROM t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("count = " + count);
    }

}