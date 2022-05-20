package com.fly.oa.service;

import com.fly.oa.dao.DeptTableDAO;
import com.fly.oa.domain.DeptTable;

import java.util.List;

/**
 * @author Fly
 * @Vision 1.0
 */

public class DeptService {
    private DeptTableDAO deptTableDAO = new DeptTableDAO();

    public List<DeptTable> list(){
        String sql = "select * from dept";
        return deptTableDAO.queryMulti(sql, DeptTable.class);
    }

    public DeptTable selectByDeptno(String deptno){
        String sql = "select * from dept where deptno = ?";
        return deptTableDAO.querySingle(sql,DeptTable.class, deptno);
    }

    public int deleteByDeptno(String deptno){
        String sql = "delete from dept where deptno = ?";
        return deptTableDAO.update(sql, deptno);
    }

    public int add(String deptno, String dname, String loc){
        String sql = "insert into dept values(?, ?, ?)";
        return deptTableDAO.update(sql, deptno, dname, loc);
    }

    public int update(String deptno, String dname, String loc){
        String sql = "update dept set dname = ?, loc = ? where deptno = ?";
        return deptTableDAO.update(sql, dname, loc, deptno);
    }
}
