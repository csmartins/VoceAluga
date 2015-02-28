package br.model;

import java.io.Serializable;

public interface EntityInterface extends Serializable, Cloneable
{
	public String getOid();

	public void setOid(String id);

}
