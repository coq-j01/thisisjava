package ch20.oracle.sec13.service;

import java.util.List;

import ch20.oracle.sec13.entity.Board;
import ch20.oracle.sec13.repository.BoardRepository;

public class BoardService {
	BoardRepository boardRepository = new BoardRepository();

	public List<Board> list() {
		return boardRepository.list();
	}
	public Board insert(Board board) {
		return boardRepository.insert(board);
	}
	public int clear() {
		return boardRepository.clear();
	}
	public Board findById(Board board) {
		return boardRepository.findById(board);
	}
	public int update(Board board) {
		return boardRepository.update(board);
	}
	public int delete(Board board) {
		return boardRepository.delete(board);
	}
}
