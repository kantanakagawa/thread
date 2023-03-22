package sample_board;
import java.io.Serializable;
import java.util.ArrayList;

public class BoardDTO implements Serializable{
	private ArrayList<Board> list;
	
	public BoardDTO() {
		list = new ArrayList<Board>();
	}
	
	public void add(Board bd) {
		list.add(bd);
	}
	
	public Board get(int i) {
		return list.get(i);
	}
	
	public int size() {
		return list.size();
	}
}