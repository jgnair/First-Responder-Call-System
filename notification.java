public class notification {
	// Variables to be used for the notifications
	private String Responder;
	private int Severity;
	private double Distance;
	private int time;
	private int caseNumber;
	notification before;
	notification after;

	// Constructor
	public notification(String responder, int severity, double distance, int Time, int Case) {
		before = null;
		after = null;
		Responder = responder;
		Severity = severity;
		Distance = distance;
		caseNumber = Case;
		time = Time;
	}

	// Getter and Setter Methods
	public void setAfter(notification child) {
		before = child;
	}

	public void setBefore(notification child) {
		after = child;
	}

	public notification getBefore() {
		return before;
	}

	public notification getAfter() {
		return after;
	}

	public int getSeverity() {
		return Severity;
	}

	public void setSeverity(int severity) {
		Severity = severity;
	}

	public double getDistance() {
		return Distance;
	}

	public void setDistance(double distance) {
		Distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int Time) {
		time = Time;
	}

	public String GetResponder() {
		return Responder;
	}

	public void setSituation(String responder) {
		Responder = responder;
	}

	public int getCase() {
		return caseNumber;
	}

	public void setCase(int Case) {
		caseNumber = Case;
	}
}
