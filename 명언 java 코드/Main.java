import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<WiseSay> WiseSays = new ArrayList<>();
        int WiseSayId = 1;


        System.out.println("======================");
		System.out.println("과제 1 : JAVA 명언 게시판");
		System.out.println("======================");	

        while (true) {
            System.out.print("(1)등록, (2)출력 (0)종료 명령은 : ");
            int input_cmd = Integer.parseInt(sc.nextLine());

            if (input_cmd==0) {
                break;
            } else if (input_cmd==1) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                WiseSays.add(new WiseSay(WiseSayId, content, author));
                System.out.println(WiseSayId + "번 명언이 등록되었습니다.");
                WiseSayId++;
            } else if (input_cmd==2) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------------");
                
                if (WiseSays.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");
                } else {
                    WiseSay latest = WiseSays.get(WiseSays.size() - 1);
                    System.out.println(latest.toString());
                }
            }
        }
        sc.close();
    }
}
