/**
 * Licensee: Institute of Technology Tallaght
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListORMweek10Data {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Employee...");
		ormtest.Employee[] ormtestEmployees = ormtest.Employee.listEmployeeByQuery(null, null);
		int length = Math.min(ormtestEmployees.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormtestEmployees[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Employee by Criteria...");
		ormtest.EmployeeCriteria lormtestEmployeeCriteria = new ormtest.EmployeeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormtestEmployeeCriteria.id.eq();
		lormtestEmployeeCriteria.setMaxResults(ROW_COUNT);
		ormtest.Employee[] ormtestEmployees = lormtestEmployeeCriteria.listEmployee();
		int length =ormtestEmployees== null ? 0 : Math.min(ormtestEmployees.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormtestEmployees[i]);
		}
		System.out.println(length + " Employee record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListORMweek10Data listORMweek10Data = new ListORMweek10Data();
			try {
				listORMweek10Data.listTestData();
				//listORMweek10Data.listByCriteria();
			}
			finally {
				ormtest.ORMweek10PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
