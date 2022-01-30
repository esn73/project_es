package OracleJdbc;

public interface OracleJdbc {
	// public static final 변수
	// public abstract 메서드
	
	// Oracle DB 접속 주소/접속 방식
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	// Oracle DB 접속 사용자 이름
	String USER = "scott";
	// Oracle DB 접속 비밀번호
	String PASSWORD = "tiger";
	
	//DB 테이블 이름
	String TABLE_DONUTS = "donuts";
	// 테이블의 컬럼 이름
	String COL_SEQ = "seq";
	String COL_GRPCD = "grpcd";
	String COL_NO = "no";
	String COL_MENUNAME = "menuname";
	String COL_COUNT = "count";
	String COL_PRICE = "price";
	String COL_SUM = "sum";
	
	String COM_ADD = "insert into " + TABLE_DONUTS 
			+ " (" + COL_GRPCD + ", "+ COL_NO + ", "+ COL_MENUNAME + ", " + COL_COUNT + ", " + COL_PRICE + ", " + COL_SUM +")"
			+" values ( ?, ?, ?, ?, ?, ?)";
}
