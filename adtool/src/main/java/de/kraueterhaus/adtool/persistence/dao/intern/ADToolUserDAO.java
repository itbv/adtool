package de.kraueterhaus.adtool.persistence.dao.intern;

import de.kraueterhaus.adtool.model.intern.ADToolUser;

public interface ADToolUserDAO
{
	public ADToolUser getUser(String userName);
}
