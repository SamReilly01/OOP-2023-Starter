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

	public class Word {
		private String word;
		private ArrayList<Follow> follows;
	
		// Constructor
		public Word(String word) {
			this.word = word;
			follows = new ArrayList<>();
		}
	
		// Accessor methods
		public String getWord() {
			return word;
		}
	
		public ArrayList<Follow> getFollows() {
			return follows;
		}
	
		// Other methods
		public void addFollow(Follow follow) {
			follows.add(follow);
		}
	
		// toString() method
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(word).append(": ");
			for (Follow follow : follows) {
				sb.append(follow.toString()).append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
			return sb.toString();
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
