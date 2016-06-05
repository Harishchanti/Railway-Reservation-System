package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		int choice, k = 0, MAX = 0, z = 0;
		int flag1, index = 0, s = 0, iii = 0;
		String PNR1 = "040-5000" + z;
		String PNR2 = PNR1;
		int flag55 = 0;
		String seatno_ac = "A/C-";
		String seatno_sl = "S/L-";
		String seatno_ac1 = "";
		int seat_ac = 0;
		int seat_sl = 0;
		int max_ac = 70;
		int max_sl = 70;
		int[] ss = new int[10];
		int[] sq = new int[10];
		Queue q1[] = new Queue[10];
		for (int h = 0; h < 10; h++) {
			q1[h] = new Queue(10);
		}
		int emptyflag[][] = new int[10][500];
		Reservation r[][] = new Reservation[10][500];
		int reserve[] = new int[10];
		Train to = new Train();
		Scanner in = new Scanner(System.in);
		InputStreamReader inn = new InputStreamReader(System.in);
		BufferedReader out2 = new BufferedReader(inn);

		while (true) {
			try {
				FileReader fr = new FileReader("Railway.txt");
				BufferedReader br = new BufferedReader(fr);
				String s1;
				while ((s1 = br.readLine()) != null) {
					System.out.println(s1);
				}
				fr.close();
			} catch (Exception e) {
				System.out.println("Error :" + e);
			}
			choice = in.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Please enter password");
				String pass1 = "pesit";
				String pass = in.next();
				if (pass1.equalsIgnoreCase(pass)) {
					System.out
							.println("1.Set Train database\n2.Prepare Final Chart");
					int ch = in.nextInt();
					switch (ch) {
					case 1:
						System.out.println("Please Enter Train details");
						MAX = to.Set_seat();
						System.out.println("Thanks for giving Information");
						break;

					case 2:
						for (int io = 0; io < 10; io++) {
							System.out
									.println("Prepare Final Chart for Train  "
											+ to.t[io] + "  (Y Or N)");
							String pp = in.next();
							if (pp.equalsIgnoreCase("y")) {
								try {
									FileWriter fstreamio = new FileWriter(
											"Finalchart" + io + ".txt");
									BufferedWriter out = new BufferedWriter(
											fstreamio);
									out.write("List of Passengers conformed for train:"
											+ to.t[io]);
									out.newLine();
									for (int y = 0; y < MAX; y++) {
										if (r[io][y] != null) {
											if (r[io][y].name != "") {
												out.write(" NAME :"
														+ r[io][y].name);
												out.newLine();
											}
											if (r[io][y].age != "") {
												out.write(" AGE :"
														+ r[io][y].age);
												out.newLine();
											}
											if (r[io][y].PNR != "") {
												out.write("PNR  :"
														+ r[io][y].PNR);
												out.newLine();
											}
											if (r[io][y].status != "") {
												out.write(" STATUS :"
														+ r[io][y].status);
												out.newLine();
											}

											if (r[io][y].seatno != "") {
												out.write(" SEAT_NO :"
														+ r[io][y].seatno);
												out.newLine();
											}
											if (r[io][y].coach != "") {
												out.write(" COACH :"
														+ r[io][y].coach);
												out.newLine();
											}
										}

									}

									out.close();
								} catch (Exception e) {
									System.out.println("Error: "
											+ e.getMessage());
								}
								System.out.println("Thank you ");
							}

							else {
								break;
							}
						}
						break;
					}

				}

				else {
					System.out.println("*******SORRY WRONG PASSWORD*******");
				}
				break;

			case 2:
				while (true) {
					System.out
							.println("Enter 1 to view Trains:\nEnter 2 for Reservation:\nEnter 3 for Cancellation:\nEnter 4 for PNR Status Check \nEnter 5 To Exit from user mode");
					int ch1 = in.nextInt();
					switch (ch1) {
					case 1:
						try {
							FileReader fr1 = new FileReader("Train.txt");
							BufferedReader br1 = new BufferedReader(fr1);
							String s1;
							while ((s1 = br1.readLine()) != null) {
								System.out.println(s1);
							}
							fr1.close();
						} catch (Exception e) {
							System.out
									.println("****Sorry Train data base is not set*****");
						}
						break;

					case 2:
						String num = "";
						String rt;
						System.out.println("Enter train name:");
						rt = out2.readLine();
						System.out.println("Enter Train number:");
						num = out2.readLine();
						int flag = 0;
						for (int f = 0; f < 10; f++) {
							if (to.t[f] != null) {
								if (rt.equalsIgnoreCase(to.t[f])
										&& num.equals((to.t1[f]))) {
									k = f;
									flag = 1;
									break;

								}
							}
						}
						if (flag != 1) {
							System.out.println("Train not Found");
						} else {
							String name1 = "";
							String age1 = "";
							if (reserve[k] < MAX) {
								System.out
										.println("Reservations are Available\n");
								if (seat_ac < max_ac && seat_sl < max_sl) {
									System.out
											.println(" Both A/c And S/L saeats are available");
								} else if (seat_sl < max_sl
										&& seat_ac >= max_ac) {
									System.out
											.println(" Only S/L seats are available");
								} else {
									System.out
											.println(" Only A/C seats are available");
								}
								for (int j = 0; j < 100; j++) {
									System.out.println("Enter your name:");
									if (check(name1 = in.next())) {
										break;
									} else {
										System.out
												.println("please Don't enter Alaphanumaric number ");
									}
								}

								for (int kkk = 0; kkk < 100; kkk++) {
									System.out.println("Enter your Age:");

									if (check1(age1 = in.next())) {
										break;
									} else {
										System.out
												.println("Please don't take Tickets for Children age less then 3 \n And Enter proper age");
									}
								}
								System.out
										.println(" Enter choice \n 1.A/C \n 2.S/L ");
								int y = in.nextInt();
								String p = "";

								switch (y) {
								case 1:
									if (seat_ac < max_ac) {
										p = "A/C";
										sq[k]++;
										seatno_ac1 = seatno_ac + sq[k];
										seat_ac++;
										break;
									} else {
										System.out
												.println(" A/C seats are over ");
										flag55 = 1;
										break;
									}

								case 2:
									if (seat_sl < max_sl) {
										p = "S/L";
										ss[k]++;
										seatno_ac1 = seatno_sl + ss[k];
										seat_sl++;
										break;
									} else {
										System.out
												.println(" S/L seats are over ");
										flag55 = 1;
										break;
									}

								}
								if (flag55 == 0) {
									z++;
									PNR2 = PNR1 + z;
									r[k][reserve[k]] = new Reservation(name1,
											age1, PNR2, p, seatno_ac1);
									r[k][reserve[k]].details();
									System.out.println("\n");
									r[k][reserve[k]].Acknowledgement(k);
									System.out.println("\n");
									reserve[k]++;
								}
							} else if (emptyflag[k][s] == 1) {
								System.out
										.println("Reservations are Available\n");
								for (int j = 0; j < 100; j++) {
									System.out.println("Enter your name:");
									if (check(name1 = in.next())) {
										break;
									} else {
										System.out
												.println("please Don't enter Alaphanumaric number ");
									}
								}

								for (int kkk = 0; kkk < 100; kkk++) {
									System.out.println("Enter your Age:");

									if (check1(age1 = in.next())) {
										break;
									} else {
										System.out
												.println("Please don't take Tickets for Children aged less then 3 \n And Enter proper age");
									}
								}

								System.out
										.println(" Enter choice \n 1.A/C \n 2.S/L ");
								int y1 = in.nextInt();
								String p1 = "";
								switch (y1) {
								case 1:
									if (seat_ac < max_ac) {
										p1 = "A/C";
										sq[k]++;
										seatno_ac1 = seatno_ac + sq[k];
										seat_ac++;
										break;
									} else {
										System.out
												.println(" A/C seats are over ");

										break;
									}

								case 2:
									if (seat_sl < max_sl) {
										p1 = "A/C";
										ss[k]++;
										seatno_ac1 = seatno_sl + ss[k];
										seat_sl++;
										break;
									} else {
										System.out
												.println(" A/C seats are over ");
										break;
									}

								}

								z++;
								PNR2 = PNR1 + z;
								r[k][s] = new Reservation(name1, age1, PNR2,
										p1, seatno_ac1);
								r[k][s].details();
								r[k][s].Acknowledgement(k);
								emptyflag[k][s] = 0;
							}
							if (flag55 == 1) {
								System.out.println("Reservations are Full");
								System.out
										.println("Add to Waiting List:(Y or N)");
								String cho = in.next();
								if (cho.equalsIgnoreCase("Y")) {
									for (int j = 0; j < 100; j++) {
										System.out.println("Enter your name:");
										if (check(name1 = in.next())) {
											break;
										} else {
											System.out
													.println("please Don't enter Alaphanumaric number ");
										}
									}

									for (int kkk = 0; kkk < 100; kkk++) {
										System.out.println("Enter your Age:");
										if (check1(age1 = in.next())) {
											break;
										} else {
											System.out
													.println("Please don't take Tickets for Children aged less then 3 \n And Enter proper age");
										}
									}

									System.out
											.printf(" Enter choice \n 1.A/C \n 2.S/L ");
									int y2 = in.nextInt();
									String p2 = "";
									switch (y2) {
									case 1:
										p2 = "A/C";
										break;

									case 2:
										p2 = "S/L";
										break;
									}

									String seatnumber = "W/L";
									z++;
									PNR2 = PNR1 + z;
									try {
										r[k][reserve[k]] = new Reservation(
												name1, age1, PNR2, p2,
												seatnumber);
										r[k][reserve[k]].status = "W/L";
										q1[k].Enqueue(r[k][reserve[k]]);

										r[k][reserve[k]].details();
										r[k][reserve[k]].Acknowledgement(k);
										reserve[k]++;
										System.out
												.println("Successfully added to W/L");
									} catch (Exception e) {
										System.out.println("ERROR:" + e);
									}

								} else {
									System.out.println("Operation aborted\n\n");
								}
							}
						}
						break;

					case 3:
						System.out.println("Enter train name:");
						String rt1 = out2.readLine();
						System.out.println("Enter Train number:");
						String num1 = out2.readLine();
						int flag5 = 0;
						for (int p = 0; p < 10; p++) {
							if (to.t[p] != null && to.t1[p] != null) {
								if ((to.t[p]).equalsIgnoreCase(rt1)
										&& num1.equals((to.t1[p]))) {
									index = p;
									flag5 = 1;
								}
							}
						}
						if (flag5 == 1) {
							int s1 = 0, flag33 = 0;
							System.out.println("Enter your name ");
							String j = in.next();
							System.out.println("Enter your age ");
							String j1 = in.next();
							System.out.println(" Enter your PNR number");
							String h1 = in.next();
							for (int i = 0; i < MAX; i++) {
								if (r[index][i] != null) {
									if (r[index][i].name.equalsIgnoreCase(j)
											&& r[index][i].age.equals(j1)
											&& r[index][i].PNR
													.equalsIgnoreCase(h1)) {
										s1 = i;
										flag33 = 1;
									}
								}
							}
							if (flag33 == 1) {
								System.out
										.println("Please Confirm Cancellation:(Y or N)");
								String chh = in.next();
								if (chh.equals("Y") || chh.equals("y")) {

									if (q1[index].size == 0
											|| r[index][s1].status
													.equals("W/L")) {
										r[index][s1].status = "Cancelled";
										r[index][s1].details();
										r[index][s1].Acknowledgement1(index);
										if (r[index][s1].coach.equals("A/C")) {
											seat_ac--;
										} else {
											seat_sl--;
										}
										r[index][s1] = new Reservation();
										q1[index].Dequeue();
										emptyflag[index][s1] = 1;
										System.out
												.println("Reservation Cancelled\n\n");
										flag1 = 1;

									} else {
										if (q1[index].size > 0) {
											r[index][s1].status = "Cancelled";
											r[index][s1].details();
											r[index][s1]
													.Acknowledgement1(index);
											r[index][s1] = (Reservation) q1[index]
													.Dequeue();
											r[index][s1].status = "Reserved";
											System.out
													.println("The Following Customer has been cleared from W/L\n\n");
											r[index][s1].details();

										} else {
											r[index][s1].status = "Cancelled";
											r[index][s1].details();
											r[index][s1]
													.Acknowledgement1(index);
											if (r[index][s1].coach
													.equals("A/C")) {
												seat_ac--;
											} else {
												seat_sl--;
											}

											r[index][s1] = new Reservation();
											emptyflag[index][s1] = 1;
											System.out
													.println("Reservation Cancelled\n\n");
										}
									}
								}
							} else {
								System.out.println("Customer not Found\n\n");
							}
						} else {
							System.out.println("Train not found");
						}
						break;

					case 4:
						System.out.println("Enter PNR number");
						String pnr = in.next();
						int l = 0,
						j = 0,
						flage44 = 0;
						for (int ll = 0; ll < 10; ll++) {
							for (int jj = 0; jj < 300; jj++) {
								if (r[ll][jj] != null) {
									if (r[ll][jj].PNR.equals(pnr)) {
										l = ll;
										j = jj;
										flage44 = 1;
										break;
									}
								}
							}
							if (flage44 == 1) {
								break;
							}
						}
						if (flage44 == 1) {
							System.out.println("Your Reservation Status:"
									+ r[l][j].status);
						} else {
							System.out.println("Your PNR was not Found");
						}
						break;
					case 5:
						iii = 1;
						break;
					}
					if (iii == 1)
						break;
				}
				break;

			case 3:
				System.exit(0);
			}
		}
	}

	public static boolean check(String j) {
		char k;
		int flag_num = 0;
		for (int i = 0; i < j.length(); i++) {
			k = j.charAt(i);
			if (k == '1' || k == '2' || k == '3' || k == '4' || k == '5'
					|| k == '6' || k == '7' || k == '8' || k == '9' || k == '0') {
				flag_num = 1;
			}
		}
		return (flag_num == 1 ? false : true);
	}

	public static boolean check1(String j) {
		int j1 = 0;
		try {
			j1 = Integer.parseInt(j);
		} catch (Exception e) {
			System.out.println("Please enter valid Input");
		}

		if (j1 <= 3 || j1 > 99) {
			return false;
		} else {
			return true;
		}
	}

}
