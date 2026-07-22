package ch20.oracle.sec13.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ch20.oracle.sec13.entity.Board;
import ch20.oracle.sec13.service.BoardService;

public class BoardController {
	Scanner scanner = new Scanner(System.in);
	BoardService boardService = new BoardService();
	public void list() {
		List<Board> arraylist = boardService.list();
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-24s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------------------------");
		for(Board board : arraylist) {
			System.out.printf("%-6d%-24s%-16s%-40s \n", 
					board.getBno(), board.getBwriter(), board.getBdate(), board.getBtitle());
		}
		mainMenu();
	}
	
	public void mainMenu() {
		Board board = new Board();
		System.out.println();
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
		
		String menuNo = scanner.nextLine();
		
		switch(menuNo) {
		case "1" -> {
			System.out.print("제목 : ");
			board.setBtitle(scanner.nextLine());
			System.out.print("내용 : ");
			board.setBcontent(scanner.nextLine());
			System.out.print("작성자 : ");
			board.setBwriter(scanner.nextLine());
			boardService.insert(board);
			list();
		}
		case "2" -> {
			System.out.print("게시글 번호 : ");
			String num = scanner.nextLine();
			board.setBno(Integer.parseInt(num));
			boardService.findById(board);
			System.out.println(">>>>> 게시물 상세 보기 <<<<<");
			System.out.println("번호 : " + board.getBno());
			System.out.println("제목 : " + board.getBtitle());
			System.out.println("작성자 : " + board.getBwriter());
			System.out.println("작성일시 : " + board.getBdate());
			System.out.println("내용 : " + board.getBcontent());
			
			System.out.println();
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("서브 메뉴: 1.Update | 2.Delete | 3.List ");
			System.out.print("메뉴 선택: ");
			
			String menuNo2 = scanner.nextLine();
			
			switch(menuNo2) {
			case "1" -> {
				System.out.print("제목 : ");
				board.setBtitle(scanner.nextLine());
				System.out.print("내용 : ");
				board.setBcontent(scanner.nextLine());
				boardService.update(board);
			}
			case "2" -> {
				boardService.delete(board);
			}
			}
			list();
		}
		case "3" -> {
			boardService.clear();
			list();
		}
		case "4" -> System.exit(0);
		}
	}
}
