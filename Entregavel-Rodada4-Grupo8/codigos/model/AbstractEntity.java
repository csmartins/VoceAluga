package br.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AbstractEntity implements EntityInterface
{

	private static final long serialVersionUID = -7315402585421699014L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected String oid;
	
	@Override
	public String getOid()
	{
		return oid;
	}

	@Override
	public void setOid(String id)
	{
		oid = id;
	}

}
