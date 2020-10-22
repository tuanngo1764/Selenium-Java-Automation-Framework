package Common;

import java.util.Date;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Random;

import java.util.Calendar;

public class Utilities {

	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	public static String generateRandomString(String randomValue) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyyHH:mm:ss");
		String tmp = dateFormat.format(currentDate).toString().replace(":", "");
		return randomValue + tmp;
	}

	public static String getRandomString(int len) {
		char[] ch = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] c = new char[len];

		SecureRandom random = new SecureRandom();
		for (int i = 0; i < len; i++) {
			c[i] = ch[random.nextInt(ch.length)];
		}
		return new String(c);
	}

	public static int generateRandomNumber(int min, int max) {
		Random rnd = new Random();
		return rnd.nextInt(max) + min;
	}

	public static String generateDepartDate(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);
		String tmp = calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DAY_OF_MONTH) + "/"
				+ calendar.get(Calendar.YEAR);
		return tmp;
	}

	public static String dateFormat(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date).toString();
	}

	public static String convertRGBToHex(String grbColor) {
		String gbr[];
		gbr = grbColor.replace("rgba(", "").split(",");
		String hex = String.format("#%02X%02X%02X", Integer.parseInt(gbr[0]), Integer.parseInt(gbr[1]),
				Integer.parseInt(gbr[2]));
		return hex.toUpperCase();
	}
}
