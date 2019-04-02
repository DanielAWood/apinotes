package api.note;
import java.util.*;
public class Notes {
	public static ArrayList<Note> notes = new ArrayList<Note>();
	public static Note addNote(String body) {
		Note newnote = new Note();
		int noteId = 1;
		boolean uniqueNote=false;
		while(noteId<=notes.size() && !uniqueNote)
		{
			uniqueNote=true;
			for(int arrayIndex=0;arrayIndex<notes.size();arrayIndex++){
				if(notes.get(arrayIndex).getId()==noteId)
				{
					noteId++;
					uniqueNote=false;
				}
			}	
		}
		newnote.setId(noteId);
		newnote.setBody(body);
		notes.add(newnote);
		return newnote;
	}
	public static Note getNoteId(int id) {
		int noteIndex=-1;
		for(int arrayIndex=0;arrayIndex<notes.size();arrayIndex++){
			if(notes.get(arrayIndex).getId()==id)
			{
				noteIndex=arrayIndex;
			}
		}
		return notes.get(noteIndex);
	}
	public static ArrayList<Note> getAllNotes() {
		return notes;
	}
	public static Note setNoteBody(int id,String body) {
		int noteIndex = -1;
		for(int arrayIndex=0;arrayIndex<notes.size();arrayIndex++){
			if(notes.get(arrayIndex).getId()==id)
			{
				noteIndex=arrayIndex;
			}
		}
		notes.get(noteIndex).setBody(body);
		return notes.get(noteIndex);
	}
	public static ArrayList<Note> findInNotes(String inputString) {
		ArrayList<Note> foundNotes= new ArrayList<Note>();
		for(int arrayIndex=notes.size()-1;arrayIndex>=0;arrayIndex--){
			if(notes.get(arrayIndex).getBody().contains(inputString))
			{
				foundNotes.add(notes.get(arrayIndex));
			}
		}
		return foundNotes;
	}
	public static String deleteNote(int id) {
		int noteIndex=-1;
		for(int arrayIndex=0;arrayIndex<notes.size();arrayIndex++){
			if(notes.get(arrayIndex).getId()==id)
			{
				noteIndex=arrayIndex;
			}
		}
		notes.remove(noteIndex);
		if(noteIndex!=-1) {
			return "Note deleted";
		}
		else{
			return "Note already removed";
		}
	}
	public static void deleteAllNotes() {
		for(int arrayIndex=notes.size()-1;arrayIndex>=0;arrayIndex--){
			notes.remove(arrayIndex);
		}
	}
}
