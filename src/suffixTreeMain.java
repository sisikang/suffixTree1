//Programmer: Sisi Kang

//Date: Oct 26
//Description: Suffix Tree

import processing.core.*;

import java.util.*;

//importing the JMusic stuff
import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.midi.*;

import java.io.UnsupportedEncodingException;
import java.net.*;



import javax.sound.midi.*;

			//make sure this class name matches your file name, if not fix.
public class suffixTreeMain extends PApplet {

	MelodyPlayer player; //play a midi sequence
	MidiFileToNotes midiNotes; //read a midi file

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("suffixTreeMain"); //change this to match above class & file name 

	}

	//setting the window size to 300x300
	public void settings() {
		size(300, 300);

	}

	//doing all the setup stuff
	public void setup() {
		/*
		fill(120, 50, 240);

		MarkovGenerator<Integer> pitchGenerator = new MarkovGenerator<Integer> ("Pitch", 3);
		MarkovGenerator<Double> rhythmGenerator = new MarkovGenerator<Double> ("Rhythm", 3);

		// returns a url
		String filePath = getPath("mid/MaryHadALittleLamb.mid");
		//playMidiFile(filePath);

		midiNotes = new MidiFileToNotes(filePath); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
													//be created with "new". Note how every object is a pointer or reference. Every. single. one.


		// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
		midiNotes.setWhichLine(0);
		
		//training
		pitchGenerator.train(midiNotes.getPitchArray()); //train with getPitcher array
		rhythmGenerator.train(midiNotes.getRhythmArray()); //train with getRhthmArray

		player = new MelodyPlayer(this, 100.0f); //bpm

		player.setup();
		player.setMelody(pitchGenerator.generate(20) ); //assignments, generating probability on each pitch
		player.setRhythm(rhythmGenerator.generate(20) ); //assignments, generating probability on each rhythm
		*/
	}

	public void draw() {
	//player.play(); //play each note in the sequence -- the player will determine whether is time for a note onset 

		textSize(12);
		
		fill(0,102, 153);
		text("Press 1 to start the unit test", 60, 120);
		text("Press 2 to rest", 60, 150);
//		text("Press 3 to Run Unit Test 2", 60, 180);
//		text("Press 4 to Run Unit Test 3", 60, 210);

	}

	//this finds the absolute path of a file
	String getPath(String path) {

		String filePath = "";
		try {
			filePath = URLDecoder.decode(getClass().getResource(path).getPath(), "UTF-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	//this function is not currently called. you may call this from setup() if you want to test
	//this just plays the midi file -- all of it via your software synth. You will not use this function in upcoming projects
	//but it could be a good debug tool.
	void playMidiFile(String filename) {
		Score theScore = new Score("Temporary score");
		Read.midi(theScore, filename);
		Play.midi(theScore);
	}

	//this starts & restarts the melody.
	public void keyPressed() {
		MidiFileToNotes midiNotesMary; //read a midi file
		
		// returns a url
		String filePath = getPath("mid/MaryHadALittleLamb.mid");
		//playMidiFile(filePath);

		midiNotesMary = new MidiFileToNotes(filePath); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must
													//be created with "new". Note how every object is a pointer or reference. Every. single. one.


		// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
		midiNotesMary.setWhichLine(0);

//		Integer[] myList = {3, 3, 3, 5, 5, 7, 7, 7, 2, 3, 5};
//		ArrayList<Integer> testList = new ArrayList(Arrays.asList(myList));
//
//		System.out.println(Arrays.asList("abracadabra".split("")));
		Tree<String> suffix_1 = new Tree(3);
		ArrayList<String> testList1 = new ArrayList();
		testList1.addAll(Arrays.asList("abracadabra".split("")));
		suffix_1.train(testList1);

		Tree<String> suffix_2 = new Tree(3);
		ArrayList<String> testList2 = new ArrayList();
		testList2.addAll(Arrays.asList("acadaacbda".split("")));
		suffix_2.train(testList2);

		Tree<String> suffix_3 = new Tree(3);
		ArrayList<String> testList3 = new ArrayList();
		testList3.addAll(Arrays.asList("abcccdaadcdaabcadad".split("")));
		suffix_3.train(testList3);

		Tree<Integer> suffix_pitch = new Tree(3);
		suffix_pitch.train(midiNotesMary.getPitchArray());

		Tree<Double> suffix_rhythm = new Tree(3);
		suffix_rhythm.train(midiNotesMary.getRhythmArray());
		 if (key == '1') {
		 	suffix_1.print();
		 	suffix_2.print();
		 	suffix_3.print();
			 suffix_pitch.print();
			 //suffix_rhythm.print();
		 }

	}
}