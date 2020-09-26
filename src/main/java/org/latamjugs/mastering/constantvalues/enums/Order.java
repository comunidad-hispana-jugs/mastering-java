package org.latamjugs.mastering.constantvalues.enums;

public class Order {


	public enum Status{
		OPEN,
		CONFIRMED,
		SHIPPED,
		DELIVERED,
		CANCELLED
	}

	public enum Rating{
		EXCELLENT,
		GOOD,
		BAD
	}

	public enum RatingV2{
		EXCELENT(1),
		GOOD(2),
		BAD(3);

		private int rating;

		RatingV2(int rating){
			this.rating = rating;
		}

		public int getRating() {
			return rating;
		}


	}

	private Order.Status status;
	private Order.Rating rating;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
}
