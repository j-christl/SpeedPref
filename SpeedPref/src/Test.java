
public class Test {

	public static void main(String[] args) {

		SpeedPref pref = new SpeedPref("preference.pref");
		
		pref.write("x", 10);
		pref.write("y", 20);
		pref.write("fullscreen", false);
		pref.write("text", "hallo Leute !!!");
		
		pref.swap("x", "y");
		pref.incrementInt("x");
		pref.decrementInt("y");
		pref.inverseBoolean("fullscreen");
		pref.copy("x", "pos_x");
		
		System.out.println(		"---"+pref.getFileName()+"---"		);
		System.out.println(		pref.readInt("pos_x")				);
		System.out.println(		pref.readInt("x")					);
		System.out.println(		pref.readInt("y")					);
		System.out.println(		pref.readBoolean("fullscreen")		);
		System.out.println(		pref.readString("text")				);
		
		pref.close();

	}

}

