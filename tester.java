import java.util.Scanner;

public class tester {

	public static void main(String[] args) {
		// Other Variables that are needed throughout the system
		int incidents = -1;
		notification[][] schedule;
		String responder = "";
		int severity = -1;
		double distance = -1;
		int time = -1;
		Scanner scan = new Scanner(System.in);
		notification[] calls;
		inputCalls call = new inputCalls();
		boolean respond = false;
		// This loop asks how many incidents are required and will continue prompting
		// until a positive non 0 integer is given
		while (incidents < 0) {
			System.out.print(
					"Input how many incidents you would like to file within the system. (Input number > 0 or message will be prompted again)\n");
			incidents = scan.nextInt();
		}
		// The following for loop and while loops ask for information about the specific
		// situations and also have recurring prompts if proper information is not
		// given. It then takes the given information and makes a notification that is
		// put into an array
		calls = new notification[incidents];
		for (int x = 0; x < incidents; x++) {
			System.out.println("Please input the information for report " + (x + 1)
					+ ". If any information is incorrectly input, it will prompt you again.");
			while (respond == false) {
				System.out.println("Which service is required: Police   Fire   Medical\n");
				responder = scan.next();
				if (responder.equalsIgnoreCase("Police")) {
					break;
				}
				if (responder.equalsIgnoreCase("Fire")) {
					break;
				}
				if (responder.equalsIgnoreCase("Medical")) {
					break;
				}
			}
			while (severity < 1 || severity > 10) {
				System.out.println("On a scale of 1-10, report how severe the situation is. 10 being most severe.\n");
				severity = scan.nextInt();
			}
			while (distance < 0) {
				System.out.println(
						"What is the distance from the nearest responder to the location of the call(in terms of miles).\n");
				distance = scan.nextDouble();
			}
			while (time < 0 || time > 24) {
				System.out.println("What is the time. Input in terms of nearest hour hh\n");
				time = scan.nextInt();
			}
			calls[x] = new notification(responder, severity, distance, time, calls.length - x);
			responder = "";
			severity = -1;
			distance = -1;
			time = -1;
		}
		// Closing out the scanner
		scan.close();
		// The next 2 for loops sort out all the notifications by
		// their respective times given.
		notification temp = null;
		for (int z = 0; z < calls.length - 1; z++) {
			for (int y = 0; y < calls.length - 1; y++) {
				if (calls[y].getTime() < calls[y + 1].getTime()) {
					temp = calls[y];
					calls[y] = calls[y + 1];
					calls[y + 1] = temp;
				} else if (calls[y].getTime() == calls[y + 1].getTime()
						&& calls[y].getSeverity() > calls[y + 1].getSeverity()) {
					temp = calls[y];
					calls[y] = calls[y + 1];
					calls[y + 1] = temp;
				}
			}
		}
		// The next for loop simply throws the whole array that has been sorted back
		// into the singly linked tree.
		for (int a = 0; a < calls.length; a++) {
			call.insert(calls[a]);
		}
		// This final for loop with if statements is what the finished result of the
		// code is. It takes the nodes/notifications one by one out of the tree and
		// determines which department it goes to from the already given information.
		// The information is then put into a 2D array based on what time they were
		// called in.
		schedule = new notification[3][calls.length];
		int policeCounter = 0;
		int medicalCounter = 0;
		int fireCounter = 0;
		for (int b = 0; b < calls.length; b++) {
			if (call.getRoot().GetResponder().equalsIgnoreCase("Police")) {
				System.out.println("New call regarding " + call.getRoot().GetResponder() + " at hour "
						+ call.getRoot().getTime() + ". Victim is " + call.getRoot().getDistance()
						+ " miles away with a level " + call.getRoot().getSeverity() + " affliction.");
				schedule[0][policeCounter] = call.acceptCall();
				policeCounter++;
			} else if (call.getRoot().GetResponder().equalsIgnoreCase("Fire")) {
				System.out.println("New call regarding " + call.getRoot().GetResponder() + " at hour "
						+ call.getRoot().getTime() + ". Victim is " + call.getRoot().getDistance()
						+ " miles away with a level " + call.getRoot().getSeverity() + " affliction.");
				schedule[1][fireCounter] = call.acceptCall();
				fireCounter++;
			} else {
				System.out.println("New call regarding " + call.getRoot().GetResponder() + " at hour "
						+ call.getRoot().getTime() + ". Victim is " + call.getRoot().getDistance()
						+ " miles away with a level " + call.getRoot().getSeverity() + " affliction.");
				schedule[2][medicalCounter] = call.acceptCall();
				medicalCounter++;
			}
		}
	}
}
