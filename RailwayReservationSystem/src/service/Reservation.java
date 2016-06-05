package service;


public class Reservation {
	String name;
	public String age;
	public String status;
	public String PNR;
	public String coach;
	public String seatno;
	Train obj = new Train();

	public Reservation(String name, String age, String PNR, String p, String k) {
		this.name = name;
		this.age = age;
		this.PNR = PNR;
		this.coach = p;
		this.seatno = k;
		this.status = "Reserved";

	}

	public Reservation() {
		this.name = "";
		this.age = "";
		this.PNR = "";
		this.status = "";
		this.coach = "";
		this.seatno = "";
	}

	public void details() {
		System.out.println("Name :" + this.name);
		System.out.println("Age :" + this.age);
		System.out.println("PNR :" + this.PNR);
		System.out.println("Coach :" + this.coach);
		System.out.println("Seat no:" + this.seatno);
		System.out.println("Status :" + this.status);

	}

	public void Acknowledgement(int k) {
		double h;

		if (this.coach.equals("A/C")) {

			int j = Integer.parseInt(this.age);
			if (j > 65) {
				System.out.println("10% discount for senior citizens\n");
				h = (Train.tno[k]) - ((Train.tno[k]) * .1);
				System.out.println("Please pay Rs " + h + "/-");
			} else {
				System.out.println("Please pay Rs " + Train.tno[k] + "/-");

			}
		}
		if (this.coach.equals("S/L")) {

			int j1 = Integer.parseInt(this.age);
			if (j1 > 65) {
				System.out.println("10% discount for senior citizens\n");
				h = (Train.tnos[k]) - ((Train.tnos[k]) * .1);
				System.out.println("Please pay Rs " + h + "/-");
			} else {
				System.out.println("Please pay Rs " + Train.tnos[k] + "/-");

			}
		}
		if (this.coach.equals(" ")) {
			System.out.println(" your tiket is not booked");
		}

	}

	public void Acknowledgement1(int k) {
		double h;
		if (this.coach.equals("A/C")) {
			int j = Integer.parseInt(this.age);
			if (j > 65) {
				System.out
						.println(" 5% Amount well be deducted from the cash you have paid ");
				h = (Train.tno[k]) - (Train.tno[k] * .1) - (Train.tno[k] * .05);
				System.out.println("Please Collect Refund of  Rs " + h + "/-");
			} else {
				System.out
						.println(" 5% Amount well be deducted from the cash you have paid ");
				System.out.println("Please Collect Refund of Rs "
						+ (Train.tno[k] - Train.tno[k] * .05) + "/-");

			}
		}

		else {
			int j2 = Integer.parseInt(this.age);
			if (j2 > 65) {
				System.out
						.println(" 5% Amount well be deducted from the cash you have paid ");
				h = (Train.tnos[k]) - (Train.tnos[k] * .1)
						- (Train.tnos[k] * .05);
				System.out.println("Please Collect Refund of  Rs " + h + "/-");
			} else {
				System.out
						.println(" 5% Amount well be deducted from the cash you have paid ");
				System.out.println("Please Collect Refund of Rs "
						+ (Train.tnos[k] - Train.tnos[k] * .05) + "/-");

			}
		}
	}

}
