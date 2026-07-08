package ch15.sec02.exam01;

public class ArrayListExample0 {
    public static void main(String[] args) {
        //ArrayList 컬렉션 생성
        Board [] list = new Board[5];

        //객체 추가
        list[0] = new Board("제목1", "내용1", "글쓴이1");
        list[1] = new Board("제목2", "내용2", "글쓴이2");
        list[2] = new Board("제목3", "내용3", "글쓴이3");
        list[3] = new Board("제목4", "내용4", "글쓴이4");
        list[4] = new Board("제목5", "내용5", "글쓴이5");

        //저장된 총 객체 수 얻기
        int size = list.length;
        System.out.println("총 객체 수: " + size);
        System.out.println();

        //특정 인덱스의 객체 가져오기
        Board board = list[2];
        System.out.println(board.getSubject() + "\t" + board.getContent() +
                                "\t" + board.getWriter());
        System.out.println();

        //모든 객체를 하나씩 가져오기
        for(int i=0; i<list.length; i++) {
            Board b = list[i];
            System.out.println(b.getSubject() + "\t" + b.getContent() +
                                "\t" + b.getWriter());
        }
        System.out.println();

        //객체 삭제
        //list.remove(2);
        //list.remove(2);
        Board [] temp = new Board[3];
        temp[0] = list[0];
        temp[1] = list[1];
        temp[2] = list[4];

        list = temp; // 바꾸는게 쉽지 않음

        //향상된 for문으로 모든 객체를 하나씩 가져오기
        for(Board b : list) {
            System.out.println(b.getSubject() + "\t" + b.getContent() +
                                "\t" + b.getWriter());
        }
    }
} 