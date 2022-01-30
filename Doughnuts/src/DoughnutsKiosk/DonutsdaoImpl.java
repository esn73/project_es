package DoughnutsKiosk;

import static OracleJdbc.OracleJdbc.COL_COUNT;
import static OracleJdbc.OracleJdbc.COL_MENUNAME;
import static OracleJdbc.OracleJdbc.COL_NO;
import static OracleJdbc.OracleJdbc.COL_PRICE;
import static OracleJdbc.OracleJdbc.COL_SUM;
import static OracleJdbc.OracleJdbc.COM_ADD;
import static OracleJdbc.OracleJdbc.PASSWORD;
import static OracleJdbc.OracleJdbc.URL;
import static OracleJdbc.OracleJdbc.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import oracle.jdbc.OracleDriver;

public class DonutsdaoImpl implements DonutsDao {
	
	
	public List<Donuts> donuts;

	@Override
	public List<Donuts> select() {
		List<Donuts> donuts = new ArrayList<Donuts>();
		
		String sqlSelect = null;		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			DriverManager.deregisterDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공2");
			
			stmt = conn.createStatement();

			
			rs = stmt.executeQuery(sqlSelect);
			System.out.println("쿼리 실행 성공2");
			while(rs.next()) { //ResultSet 레코드(행, row)가 있으면
				int no = rs.getInt(COL_NO);
				String menuName = rs.getString(COL_MENUNAME);
				int count = rs.getInt(COL_COUNT);
				int price = rs.getInt(COL_PRICE);
				int sum = rs.getInt(COL_SUM);

				Donuts sc = new Donuts(no, menuName, count, price);
				
				donuts.add(sc);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close(); 
				conn.close();
				System.out.println("DB 연결 끊기 성공");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return donuts;
	}
	
	
	private static DonutsdaoImpl instance = null;
	private DonutsdaoImpl() {}
	public static DonutsdaoImpl getInstance() {
		if(instance == null) {
			instance = new DonutsdaoImpl();
		}
		return instance;
	}
	
	
	@Override
	public Donuts slecet(int index) {
		Donuts result = null;
		if(index >= 0 && index < donuts.size()) {
			
		}
		return result;
	}

	@Override
	public int insert(List<Donuts> d) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = COM_ADD;
			System.out.println(sql);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Calendar c1 = Calendar.getInstance();
			String grpCd = sdf.format(c1.getTime());

			for(int i=0;i<d.size();i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, grpCd);
				pstmt.setInt(2, d.get(i).getNo());
				pstmt.setString(3, d.get(i).getMenuName());
				pstmt.setInt(4, d.get(i).getCount());	
				pstmt.setInt(5, d.get(i).getPrice());
				pstmt.setInt(6, d.get(i).getSum());
				result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		schedules.add(s);		
		return result;
	}

	@Override
	public int update(Donuts d) {
		return 0;

	}

	@Override
	public int delete(int index) {
		return 0;
	}

}
