package org.latamjugs.mastering.override.obj;

import java.util.List;
import java.util.Objects;

public class User {

	private String name;
	private String password;

	private List<Role> rolList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRolList() {
		return rolList;
	}

	public void setRolList(List<Role> rolList) {
		this.rolList = rolList;
	}

	/*public String toString(){
		return String.format(" name := "+name+ " y el password es:= "+password);
	}*/


	public boolean equals(Object obj){

		if (obj == this) {
			return true;
		}

		if (!(obj instanceof User)) {
			return false;
		}

		User user = (User) obj;

		if (user.getName() == this.getName()){
			if (user.getPassword() == this.getPassword()){
				return true;
			}
		}
		return false;
	}


	//@Override
	public int hashCode() {
		//Forma correcta
		return Objects.hash(name, password, rolList);
	}

	/*@Override
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + (name == null ? 0 : name.hashCode());
		hash = 31 * hash + (password == null ? 0 : password.hashCode());
		return hash;
	}*/
	 
}
