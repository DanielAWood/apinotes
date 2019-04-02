package api.note;
import java.util.*;
import javax.ws.rs.*;
import javax.json.*;
import java.io.*;
@Path("/notes")
public class NoteService {
	// if testing in Windows: curl -i -H "Content-Type: application/json" -X POST -d '{"body\" : \"Pick up milk!"}' http://localhost:8080/api/notes
	// TO DO: test curl -i -H "Content-Type: application/json" -X POST -d '{"body" : "Pick up milk!"}' http://localhost:8080/api/notes
	@POST@Path("")
	@HeaderParam("Content-Type: application/json")
	@Produces("application/json")
	@Consumes("application/json")
	public Note postNote(String inputString){ //somehow need to take in actual JSON string...
		JsonReader jsonReader = Json.createReader(new StringReader(inputString));
		JsonObject array = jsonReader.readObject();
		jsonReader.close(); 
		String body=array.getString("body");
		Note newnote = new Note();
		newnote = Notes.addNote(body);
		return newnote;		
	}
			
	@GET@Path("")
	@HeaderParam("Content-Type: application/json")
	@Produces("application/json")
	public static ArrayList<Note> getAllNotes() { 
		return Notes.notes;
	}

	@GET@Path("")
	@HeaderParam("Content-Type: application/json")
	@Produces("application/json")
	public static ArrayList<Note> searchNotes(@DefaultValue("")@QueryParam("query") String searchString) { 
		ArrayList<Note> foundNotes= new ArrayList<Note>();
		foundNotes=Notes.findInNotes(searchString);
		return foundNotes;
	}
	
	@GET@Path("/{id}")
	@HeaderParam("Content-Type: application/json")
	@Produces("application/json")
	public static Note getNote(@PathParam("id") int id,String inputString) { return Notes.getNoteId(id);}
	
	@PUT@Path("/{id}")
	@HeaderParam("Content-Type: application/json")
	@Produces("application/json")
	@Consumes("application/json")
	public static Note setNote(@PathParam("id") int id,String inputString) { 
		JsonReader jsonReader = Json.createReader(new StringReader(inputString));
		JsonObject array = jsonReader.readObject();
		jsonReader.close(); 
		String body=array.getString("body");
		Notes.getNoteId(id).setBody(body);
		return Notes.getNoteId(id);}
	
	@DELETE@Path("")
	@HeaderParam("Content-Type: application/json")
	@Produces("application/json")
	public static ArrayList<Note> deleteNotes() { Notes.deleteAllNotes(); return Notes.notes;}
	
	@DELETE@Path("{id}")
	@HeaderParam("Content-Type: application/json")
	@Produces("application/json")
	public static String deleteNote(@PathParam("id") int id) { return Notes.deleteNote(id);}
}
