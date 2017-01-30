package dbconnect;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;





public class DBconnect_main extends Frame implements WindowListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBconnect_main dbgraph = new DBconnect_main();
		 dbgraph.setBounds(5,5,655,455);
		 dbgraph.setVisible(true);
	}
	public DBconnect_main(){
		addWindowListener(this);
		setTitle("DBGraph");
		int id,ton;
		String name,year;
		ResultSet rs;
		MySQL mysql = new MySQL();
	    rs = mysql.selectAll();
	    DefaultCategoryDataset data = new DefaultCategoryDataset();
	    try {
			while(rs.next()){
			id = rs.getInt("id");
			name = rs.getString("name");
			year = rs.getString("year");
			ton = rs.getInt("ton");
			System.out.println("ID�F" + id);
			System.out.println("name�F" + name);
			System.out.println("year�F" + year);
			System.out.println("ton�F" + ton);
			data.addValue (ton,name,year);
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    JFreeChart chart = ChartFactory.createLineChart("Import Volume","Year","Ton",data,PlotOrientation.HORIZONTAL,true,false,false);
	    
		ChartPanel cpanel = new ChartPanel(chart);
	    add(cpanel, BorderLayout.CENTER);
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}




