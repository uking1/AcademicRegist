package Main;

import java.util.Scanner;

public class AcademicRegisterMain {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		boolean flag = false;

		while (!flag) {

			System.out.println("미래대학교 수강 신청 프로그램");
			System.out.println("해당 번호를 입력하세요>>");
			int num = scan.nextInt();
			scan.nextLine();

			switch (num) {
			case 1:
				System.out.println("학과 정보 목록/입력/수정/삭제");
				
				break;
			case 2:
				System.out.println("학생 정보 목록/입력/수정");
				
				break;
			case 3:
				System.out.println("과목 정보 목록/입력/수정/삭제");
				
				break;
			case 4:
				System.out.println("수강 신청 목록/신청/취소");
				
				break;
			case 5:
				flag = true;
				System.out.println("프로그램을 종료합니다.");
				break;

			}
		}

	}

}
