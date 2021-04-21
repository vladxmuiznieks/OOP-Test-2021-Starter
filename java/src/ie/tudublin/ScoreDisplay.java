package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	String score = "DEFGABcd";
	ArrayList<Note> notes = new ArrayList<Note>();
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	void printScores() {
		for (Note note : notes) {
			System.out.println(note.toString());
		}
	}

	void loadScore(String score) {
		for (int i = 0; i < score.length(); i++) {
			char note = score.charAt(i);
			char duration;
			int numberDuration = 1;
			if (i < score.length() - 1) {
				duration = score.charAt(i + 1);
				if (duration == '2') {
					numberDuration = 2;
					i++;
				}
			}
			notes.add(new Note(note, numberDuration));
		}
	}
	
	public void settings()
	{
		size(1000, 700);
		

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	void drawStaveLines() {
		for(int i = 50; i < 300; i+=50) {
			line(100, i, 800, i);
		}
	}

	public void setup() 
	{
		size(1000, 700);
	
		loadScore("A2F2GGG");
		printScores();
	}

	public void draw()
	{
		background(255);
		drawStaveLines();
		
	

	}

	void drawNotes()
	{
	}
	
}
