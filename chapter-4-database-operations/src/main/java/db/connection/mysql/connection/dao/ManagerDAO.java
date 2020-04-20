package db.connection.mysql.connection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.connection.mysql.connection.DbSQLQuery;
import db.connection.mysql.connection.model.Employee;
import db.connection.mysql.connection.model.Manager;

public class ManagerDAO {

	public List<Manager> loadAllActiveManagers() {

		List<Manager> managers = new ArrayList<Manager>();// list tanimladik

		String sql = "select emp.*, dm.*, dp.* from employees emp "
				+ "left join dept_manager dm on dm.emp_no = emp.emp_no "
				+ "left join departments dp on dp.dept_no = dm.dept_no where dm.to_date >= NOW();";// sql sorgusu
		// sql sorgusu aciklamasi : where dm.to data >= Now(); demek simdiye kadar
		// calisan
		// elect emp.*, dm.*, dp.* from employees emp // her sey sec dp kisaltma (yazma
		// taktiki) , employee tablodan
		// left join // demek left join merkez nokta dusunun soldaki tablo butun
		// bilgileri getir sagdaki tabloda ki karsi degerler var olan ve yok olan (
		// asagdaki row null gozukebilir )
		// on // demek bizim yaptigimiz froinkey onun userinden baglantisi yuruyor .
		ResultSet resultSet = DbSQLQuery.select(sql);// veritaban baglanma icin
		try {
			if (resultSet == null) {
				return managers;// bos ise dondur
			}

			while (resultSet.next()) {// bos degil ise
				Manager manager = new Manager();// object olustur ki cunku manager class ta bos construcotor yok ben
												// olusturdum
				Employee employee = employeeBilgileriGetir(resultSet);// employee bilgileri alalim
				manager.setEmployee(employee);// burda setledik
				manager.setDepartmentName(resultSet.getString("dept_name"));// hamgi sirket te adi setledik
				managers.add(manager);// ve dziye ekledik

				// managers.add(ManagerListesi(resultSet));

			}
		} catch (Exception e) {

		}
		return managers; // bitirdigi zaman dondur service => application => ekran
	}

	public Employee employeeBilgileriGetir(ResultSet resultSet) throws SQLException {// emplyee bilgileri // hata
																						// firaltabilir

		Employee employee = new Employee();
		employee.setId(resultSet.getLong("emp_no"));
		employee.setName(resultSet.getString("first_name"));
		employee.setLastName(resultSet.getString("last_name"));// resutSet onemli
		employee.setGender(resultSet.getString("gender"));
		employee.setBirthDate(resultSet.getDate("birth_date"));
		employee.setHireDate(resultSet.getDate("hire_date"));

		return employee;// donduruyoruz

//			Manager manager=new Manager();
//			manager.setDepartmentName(resultSet.getString("dept_name"));
//			manager.setEmployee(employee);
//			

	}

}
