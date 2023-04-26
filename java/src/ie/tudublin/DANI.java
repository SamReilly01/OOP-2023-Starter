package ie.tudublin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import processing.core.PApplet;

public class DANI extends PApplet {
	private ArrayList<Word> model;

	public DANI() {
        model = new ArrayList<>();
    }

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

		public Follow findFollow(String str) {
			for (Follow f : follows) {
				if (f.getWord().equals(str)) {
					return f;
				}
			}
			return null;
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

    public void loadFile(String filename) {
        String[] lines = loadStrings(filename);
        for (String line : lines) {
            String[] words = split(line, ' ');
            for (int i = 0; i < words.length - 1; i++) {
                String word = words[i].replaceAll("[^\\w\\s]", "").toLowerCase();
                String nextWord = words[i+1].replaceAll("[^\\w\\s]", "").toLowerCase();
                Word w = findWord(word);
                if (w == null) {
                    w = new Word(word);
                    model.add(w);
                }
                Follow f = w.findFollow(nextWord);
                if (f == null) {
                    f = new Follow(nextWord);
                    w.addFollow(f);
                } else {
                    f.incrementCount();
                }
            }
        }
    }

    public Word findWord(String str) {
        for (Word w : model) {
            if (w.getWord().equals(str)) {
                return w;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DANI dani = new DANI();
        dani.loadFile("small.txt");
		String sonnet = dani.writeSonnet();
		System.out.println(sonnet); //generate sonnet
        System.out.println(dani); //print sonnet

    }

	public void printModel() {
		for (Word w : model) {
			System.out.print(w.getWord() + ":");
			for (Follow f : w.getFollows()) {
				System.out.print(" " + f.getWord() + "(" + f.getCount() + ")");
			}
			System.out.println();
		}
	}
	

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

    public String writeSonnet() {
		String sonnet = "";
		Random rand = new Random();
		Word currentWord = model.get(rand.nextInt(model.size())); // pick a random word to start
		for (int i = 0; i < 14; i++) { // 14 lines in a sonnet
			String line = currentWord.getWord();
			for (int j = 0; j < 8; j++) { // 8 words per line
				if (currentWord.getFollows().isEmpty()) { // if no follows, finish the sentence
					break;
				}
				Follow followWord = currentWord.getFollows().get(rand.nextInt(currentWord.getFollows().size()));
				line += " " + followWord.getWord();
				currentWord = findWord(followWord.getWord());
			}
			sonnet += line + "\n";
			currentWord = model.get(rand.nextInt(model.size())); // start new line with new random word
		}
		return sonnet;
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
