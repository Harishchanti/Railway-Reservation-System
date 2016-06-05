package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Train {
	public String t[] = new String[10];
	public String t1[] = new String[10];
	public int no;
	public String rate, rates;
	public static int tno[] = new int[10];
	public static int tnos[] = new int[10];
	

	public String train_no;
	public String no_Seat;
	Scanner in = new Scanner(System.in);
	InputStreamReader inn = new InputStreamReader(System.in);
	BufferedReader out1 = new BufferedReader(inn);
	public String name;
	public String b_name, d_name;

	public int Set_seat() {
		String ch;
		try {
			FileWriter fstream = new FileWriter("Train.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("Train name      Train number      Bording Station      Destination Station");
			int i = 0;
			do {
				System.out.println("Enter Train name:");
				name = out1.readLine();
				t[i] = name;

				System.out.println("Enter Train number:");
				train_no = out1.readLine();
				t1[i] = train_no;
				System.out.println("Enter Boarding Station:");
				b_name = out1.readLine();
				System.out.println("Enter Destination Station:");
				d_name = out1.readLine();

				System.out
						.println("Enter Ticket rate for A/C coach in this Train :");
				for (int io = 0; io < 100; io++) {

					if (Acheck(rate = in.next())) {
						int rate1 = Integer.parseInt(rate);
						tno[i] = rate1;
						break;
					} else {
						System.out
								.println(" Enter proper Input ie.input numbers");
					}

				}

				System.out
						.println("Enter Ticket rate for S/L coach in this Train :");
				for (int io1 = 0; io1 < 100; io1++) {

					if (Acheck(rates = in.next())) {
						int rates2 = Integer.parseInt(rates);
						tnos[i] = rates2;
						break;
					} else {
						System.out
								.println(" Enter proper Input ie.input numbers");
					}

				}
				out.newLine();
				out.write(name + "                 " + train_no
						+ "                " + b_name + "                "
						+ d_name);
				out.newLine();
				System.out
						.println("Do you want to add one more Record(Y or N)");
				ch = in.next();
				i++;
				if (i == 10) {
					System.out.println("Database Full");
				}
			} while (ch.equalsIgnoreCase("y") && i < 10);
			out.close();

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		no = 140;

		return no;

	}

	static boolean Acheck(String UU) {
		char l;
		for (int ii = 0; ii < UU.length(); ii++) {

			l = UU.charAt(ii);

			if (l == 'a' || l == 'A' || l == 'b' || l == 'B' || l == 'c'
					|| l == 'C' || l == 'd' || l == 'e' || l == 'f' || l == 'g'
					|| l == 'h' || l == 'i' || l == 'j' || l == 'k' || l == 'l'
					|| l == 'm' || l == 'n' || l == 'o' || l == 'p' || l == 'q'
					|| l == 'r' || l == 's' || l == 't' || l == 'u' || l == 'v'
					|| l == 'w' || l == 'x' || l == 'y' || l == 'z') {
				return false;
			}
		}
		return true;
	}
}