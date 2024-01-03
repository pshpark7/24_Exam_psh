import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Main {
	public static void main(String[] args) {

		int LastId = 0;
		List<wiseSaying> wisesayings = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		
		System.out.println("== 명언 앱 실행 ==");

		while (true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine();

			if (cmd.equals("등록")) {

				int id = LastId + 1;

				System.out.print("명언 : ");
				String content = sc.nextLine();
				System.out.print("작가 : ");
				String author = sc.nextLine();
				String regDate =sdf1.format(now);
				wiseSaying wisesaying = new wiseSaying(id, content, author,regDate);
				
				wisesayings.add(wisesaying);
				System.out.printf("%d번 명언이 등록되었습니다.\n", id);
				LastId++;
				
			} else if (cmd.equals("목록")) {
				System.out.println("번호  / 작가 / 명언");
				System.out.println("============================");
				for (int i = wisesayings.size() -1; i >= 0; i--) {
					wiseSaying list = wisesayings.get(i);
					System.out.printf("%d  / %s  / %s\n",list.getId(),list.getAuthor(),list.getContent());
				}
			} else if (cmd.startsWith("삭제")) {
				String[] cmdBits = cmd.split("\\?", 2);
				String[] paramBits = cmdBits[2].split("=", 2);
				
				int id = Integer.parseInt(paramBits[2]);
				wiseSaying wisesaying = null;
				for (wiseSaying wiseSaying : wisesayings) {
					if (wisesaying.getId() == id) {
						wisesaying = wisesaying;			
				}
				if (wisesaying == null) {
					System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
					return;
				}
				wisesayings.remove(wisesaying);
				System.out.printf("%d번 명언이 수정되었습니다.\n",id);
			}
					}
				}


		}
	}


