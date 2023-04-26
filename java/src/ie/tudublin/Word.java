package ie.tudublin;

import java.util.ArrayList;

public class Word {

    private String word;
		ArrayList<Follow> follows = new ArrayList<Follow>();
        public Word(String word, ArrayList<Follow> follows) {
            this.word = word;
            this.follows = follows;
        }
        public String getWord() {
            return word;
        }
        public void setWord(String word) {
            this.word = word;
        }
        public ArrayList<Follow> getFollows() {
            return follows;
        }
        public void setFollows(ArrayList<Follow> follows) {
            this.follows = follows;
        }

        public String toString() {
            return "word [word=" + word + ", follows=" + follows + "]";
        }

        public void findFollow(String str) {
            for (int i = 0; i < follows.size(); i++) {
                Follow f = follows.get(i);
                if (f.getWord().equals(str)) {
                    f.setCount(f.getCount() + 1);
                    return;
                }
            }
            Follow f = new Follow(str, 1);
            follows.add(f);
        }
		
}
