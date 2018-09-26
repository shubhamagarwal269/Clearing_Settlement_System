import com.dao.PopulateDatabase;
import com.dao_impl.PopulateDatabseImpl;

public class TestPopulate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulateDatabase popDB = new PopulateDatabseImpl();
		popDB.populateSecurityTable();
	}

}
