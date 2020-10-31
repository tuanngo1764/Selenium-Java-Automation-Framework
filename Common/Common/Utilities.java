package Common;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import Constant.SeatType;
import Constant.Station;

public class Utilities {

	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	public static String generateRandomString(String randomValue) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyHH:mm:ss");
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
		String tmp = (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH) + "/"
				+ calendar.get(Calendar.YEAR);
		return tmp;
	}

	public static String generateRandomStationName() {
		List<String> departStations = Station.getAllStationName();
		return departStations.get(generateRandomNumber(0, departStations.size()) - 1);
	}

	public static String generateRandomArriveAtStationName(String departFrom) {
		List<String> departStations = Station.getAllStationName();
		departStations.remove(departStations.indexOf(departFrom));
		return departStations.get(generateRandomNumber(0, departStations.size()) - 1);
	}
	
	public static String generateRandomTypeName() {
		List<String> seatTypes = SeatType.getAllTypeName();
		return seatTypes.get(generateRandomNumber(0, seatTypes.size()) - 1);
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
