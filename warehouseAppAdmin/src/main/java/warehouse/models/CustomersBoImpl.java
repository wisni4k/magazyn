package warehouse.models;

public class CustomersBoImpl implements CustomerBo {

	CustomerDao customerDao;

	@Override
	public void save(Customers customers) {
		customerDao.save(customers);
	}

}
