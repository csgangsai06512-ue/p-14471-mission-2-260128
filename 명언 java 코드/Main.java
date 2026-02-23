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
            System.out.print("(1)등록, (2)출력 (3)삭제 (4)수정 (0)종료 명령은 : ");
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
					for (int i = 0; i < WiseSays.size(); i++) {    
						System.out.println(WiseSays.get(i).toString());
					}
                }
            } else if(input_cmd==3) {
                System.out.print("삭제 번호 : ");
                String str_del = sc.nextLine();
                int n_del = Integer.parseInt(str_del);
                boolean bDel = false;

                if (WiseSays.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");
                } else {

					for (int i = 0; i < WiseSays.size(); i++) {
						if (WiseSays.get(i).getId() == n_del) {      
							System.out.println("삭제 번호 : " + WiseSays.get(i).getId());
							bDel = true;
							WiseSays.remove(WiseSays.get(i));  
							break;
						}  
					}
				}
				
				if(!bDel) { 
					System.out.println(str_del + "번 등록된 명언이 없습니다.");  
				}			
				
            } else if (input_cmd==4) {
                System.out.print("수정 번호 : ");
                String modify = sc.nextLine();
                int n_modify = Integer.parseInt(modify);
				boolean bModify = false;


                if (WiseSays.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");
                } else {
					for (int i = 0; i < WiseSays.size(); i++) {
						if (WiseSays.get(i).getId() == n_modify) {
							System.out.print("명언 입력 : ");
							String content = sc.nextLine(); 
							WiseSays.get(i).setContent(content);  
							System.out.print("작가 입력 : ");
							String author = sc.nextLine(); 
							WiseSays.get(i).setAuthor(author);
							bModify = true;
						}
					}                                      
				}
				
				if(!bModify) { 
					System.out.println(modify + "번 등록된 명언이 없습니다.");  
				}
				
            }

        }
        sc.close();
    }
}
