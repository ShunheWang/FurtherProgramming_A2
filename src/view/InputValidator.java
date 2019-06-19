package view;

public class InputValidator {
	// check the interface input is empty
		public static boolean isEmpty(String str) {
			if (str.equals("")||str==null) {
				return false;
			}
			return true;
		}

		// Check the interface input is number only
		public static boolean isNumeric(String str) {
			for (int i = 0; i < str.length(); i++) {
				if (!Character.isDigit(str.charAt(i))) {
					return false;
				}
			}
			return true;
		}

		// check the interface input is String
		public static boolean isString(String str) {
			if (str.matches("[a-zA-Z ]+")) {
				return true;
			}
			return false;
		}
}
