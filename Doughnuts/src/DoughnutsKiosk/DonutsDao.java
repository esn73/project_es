package DoughnutsKiosk;

import java.util.List;


public interface DonutsDao {
	
	List<Donuts> select();
	Donuts slecet(int index);
	int insert(List<Donuts> d);
	int update(Donuts d);
	int delete(int index);
	
	

}
