package sample_board;
import java.io.Serializable;

public class Board implements Serializable{
	private int id;
	private String name;
	private String content;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}