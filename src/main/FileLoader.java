package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import cell.WatorCell;
import universe.Universe;
import universe.WatorUniverse;

public class FileLoader {
	private String filePath;
	private Universe universe;
	private String simulationMode;
	
	public FileLoader(String filePath, String simulationMode){
		this.filePath = filePath;
		this.simulationMode = simulationMode;
	}
	
	/**
	 * Allow user to load universe from a file.
	 * The file must be like this :
	 * The first line is the horizontal number of cell,
	 * The second line is the vertical number of cell,
	 * At the third line became the universe description,
	 * To add a shark, write 'S',
	 * To add a fish, write 'F',
	 * Any other character for null.
	 * The world description must finish with 'END' at the last line.
	 * For Example :
	 * 5
	 * 4
	 * 00SS0
	 * 0SS0F
	 * 000FF
	 * 000FF
	 * END
	 * @return True if the file has been loaded, false otherwise
	 */
	public boolean loadFile(){
		String line = "";
		int x = 0;
		int y = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			int width = Integer.parseInt(in.readLine());
			int heigh = Integer.parseInt(in.readLine());
			
			switch(simulationMode){
			case "Wator":
				universe = new WatorUniverse(width, heigh);
			}
			
			while(!(line = in.readLine()).equals("END")){
				for (char c : line.toCharArray()) {
					switch(c){
					case 'S':
						universe.addCell(new WatorCell("Shark"), x, y);
						break;
					case 'F':
						universe.addCell(new WatorCell("Fish"), x, y);
						break;
					}
					x++;
				}
				x = 0;
				y++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Universe getUniverse(){
		return this.universe;
	}
}
