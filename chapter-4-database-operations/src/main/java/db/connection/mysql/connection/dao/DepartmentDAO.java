package db.connection.mysql.connection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import db.connection.mysql.connection.DbSQLQuery;
import db.connection.mysql.connection.model.Department;


public class DepartmentDAO {

	private static final Logger logger = Logger.getLogger(DepartmentDAO.class);

public List<Department> getAll() {
		
		List<Department> departments = new ArrayList<Department>();
		
	
		ResultSet resultSet = DbSQLQuery.select("SELECT * FROM departments ");// hepsi getir 
		
		try {
			if (resultSet ==null) {
				return departments;
			}
			while (resultSet.next()) {
				departments.add(createDepartment(resultSet));// ekledik arraylist e 
			}
	
			
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return departments;// bitirdigi zaman dondur service => application => ekran
	}
        private Department createDepartment(ResultSet resultSet) throws SQLException {
		
		Department department = new Department();// object
		
		department.setName(resultSet.getString("dept_name"));// burda resultSet onemli cunku veritabandan gelen bilgiler icindedei
		department.setDeptNo(resultSet.getString("dept_no"));// o yuzden burda dikkat gerekmeli 
		
		
		return department;
	}
}
