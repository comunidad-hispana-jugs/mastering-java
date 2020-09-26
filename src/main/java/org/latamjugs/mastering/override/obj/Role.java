package org.latamjugs.mastering.override.obj;

public class Role {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("El nombre es := "+name);
	}
}
