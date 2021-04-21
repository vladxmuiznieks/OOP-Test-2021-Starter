package ie.tudublin;

import java.util.ArrayList;
import java.util.Map;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	ArrayList<Note> notes = new ArrayList<Note>();
	Map<Character, Integer> noteToHeight = Map.of(
		'D', 8,  // 8*50 = 400
		'E', 7, 
		'F', 6,
		'G', 5,
		'A', 4,
		'B', 3,
		'c', 2,  // 2*50 = 100
		'd', 1
	);


	void printScores() {
		for (Note note : notes) {
			System.out.println(note.toString());
		}
	}

	void loadScore(String score) {
		for (int i = 0; i < score.length(); i++) { // iterate the string
			char note = score.charAt(i);
			char duration;
			int numberDuration = 1;
			if (i < score.length() - 1) {  // Don't look at the next character if we're at the end of the string.
				duration = score.charAt(i + 1);
				if (duration == '2') {  // If the character is a '2' that means that it's a crochet.
					numberDuration = 2;
					i++;  // Skip the number.
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
			line(0, i, 800, i);
		}
	}

	void drawNote(Note note, int x) {
		Integer height = noteToHeight.get(note.note);
		circle(x, height*25+75, 50);
		line(x+25, height*25+75, x+25, height*25+75-100);
		if (note.duration == 2) {  // Draw the tick on top if it's a crochet.
			line(x+25, height*25+75-100, x+50, height*25+75-100+25);
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
		int i = 1;
		for (Note note : notes) {
			drawNote(note, i*65);
			i++;
		}
	}

	void drawNotes()
	{
	}
	
}
