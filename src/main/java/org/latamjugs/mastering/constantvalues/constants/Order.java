package org.latamjugs.mastering.constantvalues.constants;

public class Order {

	private String rating;
	private int status;

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order{" +
				"rating='" + rating + '\'' +
				", status=" + status +
				'}';
	}
}
