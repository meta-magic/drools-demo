package com.drools.entity;

import javax.jdo.annotations.Cacheable;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
@Cacheable("false")
public class DroolsDRL implements Entity{
	
	@PrimaryKey
	@Persistent(column = "_id", customValueStrategy = "uuid")
	private String id;

	private String name;
	
	private String dsl;

	private String pkg;
	
	private String className;
	
	public DroolsDRL(){
		super();
	}
	
	public DroolsDRL(String id){
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDsl() {
		return dsl;
	}

	public void setDsl(String dsl) {
		this.dsl = dsl;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String primaryField() {
		return "id";
	}

	@Override
	public String primaryKey() {
		return this.getId();
	}

	@Override
	public String primaryDisplay() {
		return this.getName();
	}
	
	
	@Override
	public String toString() {
		return "Key = ["+this.primaryKey()+"] Value = ["+this.primaryDisplay()+"]";
	}

}
