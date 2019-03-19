package com.driot.entity;

import javax.jdo.annotations.Cacheable;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true",table = "DroolsDRL")
@Cacheable("false")
public class DriotDRL implements Entity{
	
	@PrimaryKey
	@Persistent(column = "_id")
	private String id;

	private String name;
	
	private String dsl;

	private String pkg;
	
	private String className;
	
	public DriotDRL(){
		super();
	}
	
	public DriotDRL(String id){
		super();
		this.id = id;
	}
	
	public DriotDRL(String id, String name, String dsl, String pkg, String className) {
		super();
		this.id = id;
		this.name = name;
		this.dsl = dsl;
		this.pkg = pkg;
		this.className = className;
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
