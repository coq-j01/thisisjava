package ch15.practice;

import java.util.ArrayList;
import java.util.List;

//15강 확인문제 7
class Board{
	private String title;
	private String content;
	
	Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public String getTitle() {return title;}
	public String getContent() {return content;}
}
class BoardDao{
	List<Board> list = new ArrayList<Board>();
	BoardDao() {
		list.add(new Board("제목1","내용1"));
		list.add(new Board("제목2","내용2"));
		list.add(new Board("제목3","내용3"));
	}
	List<Board> getBoardList() {
		return list;
	}
}
public class ListExample {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for(Board board : list) {
			System.out.println(board.getTitle() + "-"+board.getContent());
		}
	}
}
