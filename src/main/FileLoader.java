package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import universe.Universe;
import universe.WatorUniverse;
import cell.WatorCell;

public class FileLoader {
	private String filePath;
	private Universe universe;
	private String simulationMode;
	
	public FileLoader(String filePath, String simulationMode){
		this.filePath = filePath;
		this.simulationMode = simulationMode;
	}
	
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
