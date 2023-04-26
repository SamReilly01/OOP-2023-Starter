package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	public class Follow {
		private String word;
		private int count;
	
		// Constructors
		public Follow(String word, int count) {
			this.word = word;
			this.count = count;
		}
	
		public Follow(String word) {
			this(word, 1);
		}
	
		// Accessor methods
		public String getWord() {
			return word;
		}
	
		public int getCount() {
			return count;
		}
	
		public void incrementCount() {
			count++;
		}
	
		// toString() method
		@Override
		public String toString() {
			return word + ": " + count;
		}
	}
	

	

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

    public String[] writeSonnet()
    {
        return null;
    }

	public void setup() {
		colorMode(HSB);

       
	}

	public void keyPressed() {

	}

	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);
        
	}
}
