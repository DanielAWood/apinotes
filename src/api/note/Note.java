package api.note;

public class Note {
	private  int id;
	private  String body;
	public Note() {
		this.id=-1;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setBody(String body) {
		this.body=body;		
	}
	public int getId() {
		return id;
	}
	public String getBody() {
		return body;
	}
}

