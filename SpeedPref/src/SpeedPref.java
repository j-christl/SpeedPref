import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;




public class SpeedPref{
	private String fileName = "";
	private File   file = null;
	private InputStream input = null;
	private HashMap<String,String> tree = new HashMap<String,String>();

	//Constructor

	public SpeedPref(String fileName){
		this.fileName = fileName;
		this.file     = new File(fileName);

		try {
			if (file.exists()==false){file.createNewFile();}
			this.input = new FileInputStream(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			while (reader.ready()){
				String[] line = reader.readLine().split("=");
				tree.put(line[0], line[1]);
			}
		} catch (IOException e){}
	}

	//Read

	public int readInt(String key){
		return Integer.parseInt(tree.get(key));
	}

	public String readString(String key){
		return tree.get(key);
	}

	public boolean readBoolean(String key){
		return (tree.get(key)=="true") ? true : false;
	}

	//Write

	public void write(String key,int value){
		tree.remove(key);
		tree.put(key, new Integer(value).toString());
	}

	public void write(String key,String value){
		tree.remove(key);
		tree.put(key, value);
	}

	public void write(String key,boolean value){
		tree.remove(key);
		tree.put(key, (value==true) ? "true":"false");
	}

	//Get

	public String getFileName() {
		return fileName;
	}

	public File getFile() {
		return file;
	}
	
	//Others
	
	public void swap(String key1,String key2){
		String temp;
		temp = tree.get(key1);
		tree.put(key1, tree.get(key2));
		tree.put(key2, temp);	
	}
	
	public void remove(String key){
		tree.remove(key);
	}
	
	public boolean exists(String key){
		return tree.get(key)!="";
	}
	
	public void changeKey(String key,String newKey){
		tree.put(newKey, tree.get(key));
		tree.remove(key);
	}
	
	public void copy(String key,String newKey){
		tree.put(newKey, tree.get(key));
	}
	
	public void inverseBoolean(String key){
		tree.put(key, tree.get(key)=="false" ? "true" : "false");
	}
	
	public void incrementInt(String key){
		int n = Integer.parseInt(tree.get(key));
		n++;
		tree.put(key, new Integer(n).toString());
	}
	
	public void decrementInt(String key){
		int n = Integer.parseInt(tree.get(key));
		n--;
		tree.put(key, new Integer(n).toString());
	}
	
	//Save

	public void save(){
		try {
			//Clear the file
			PrintWriter pwriter = new PrintWriter(file);
			pwriter.print("");
			pwriter.close();
			//Write into the file
			FileWriter writer = new FileWriter(file,true);
			for (Map.Entry e : tree.entrySet()){
				writer.write(e.getKey()+"="+e.getValue()+"\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void close(){
		this.save();
		file = null;
		tree = null;
	}




}

