package warehouse.models;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void save(Customers customers) {
		getHibernateTemplate().save(customers);
	}

}
