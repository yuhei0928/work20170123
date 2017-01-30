package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
String driver;
String server, dbname, url, user, password;
Connection con;
Statement stmt;
ResultSet rs;
public MySQL() {

this.driver = "org.gjt.mm.mysql.Driver";
this.server = "ms000.sist.ac.jp"; // MySQL�T�[�o ( IP �܂��� �z�X�g�� );
this.dbname = "java2016"; // �f�[�^�x�[�X��
this.url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";

	this.user = "java2016";
	this.password ="java2016";
	
	try {
		this.con = DriverManager.getConnection(url, user, password);
		this.stmt = con.createStatement ();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Class.forName (driver);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void close(){
	try {
		rs.close();
		stmt.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public ResultSet selectAll(){
	String sql = "SELECT * FROM `50516051`";
	ResultSet rs = null;
	try {
		rs = stmt.executeQuery (sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //try catch�ň͂�
	return rs;

 }

}
