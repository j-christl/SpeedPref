
public class Test {

	public static void main(String[] args) {
		
		
		
		
		SpeedPref pref = new SpeedPref("preference.pref");
		
		pref.write("x", 10);
		pref.write("y", 20);
		pref.write("fullscreen", true);
		
		System.out.println(pref.readInt("x"));
		System.out.println(pref.readInt("y"));
		System.out.println(pref.readBoolean("fullscreen"));
		
		pref.close();
		
		
		
	}

}

