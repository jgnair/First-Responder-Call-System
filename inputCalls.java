public class inputCalls {
	// Using a simpler form of a singly linked binary tree in this code
	// creating the starting null point of the root
	private notification root = null;

	// Method to find a specific case number
	public notification find(int Case) {
		notification pointer = root;
		while (pointer.getCase() != Case) {
			if (pointer.getCase() == Case) {
				break;
			} else {
				pointer = pointer.getBefore();
			}
			if (pointer == null) {
				break;
			}
		}
		return pointer;
	}

	// Method to add new notifications to the tree
	public void insert(notification call) {
		int Case = call.getCase();
		System.out.println("Situation: " + call.GetResponder() + " Severity Number: " + call.getSeverity()
				+ " Distance From Situation: " + call.getDistance() + " miles Called in at hour: " + call.getTime()
				+ " Assigned Case Number: " + Case);
		if (root == null) {
			root = call;
		} else {
			notification temp = root;
			while (temp.getBefore() != null) {
				temp = temp.getBefore();
			}
			call.setBefore(temp);
			temp.setAfter(call);
			while (temp.getBefore() != null) {
				temp = temp.getBefore();
			}
			root = temp;

		}
	}

	// Method that accepts the current root node and then removes it from the tree
	public notification acceptCall() {
		notification call = root;
		root = root.getAfter();
		return call;
	}

	// Method to return the root notification
	public notification getRoot() {
		return root;
	}
}