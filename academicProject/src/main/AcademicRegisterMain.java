package main;

import java.util.Scanner;

import controller.SubjectRegisterManager;
import view.MENU_CHOICE;
import view.MenuView;
import view.SUBJECT_CHOICE;

public class AcademicRegisterMain {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flag = false;

		
		while (!flag) {
			try {
			MenuView.mainMenuView();
			int num = MenuView.scan.nextInt();
			
			switch (num) {
			case MENU_CHOICE.subject:
				subjectMenu();
				break;
			case MENU_CHOICE.studnet:
//				studentMenu();
				break;
			case MENU_CHOICE.lesson:
//				lessonMenu();
				break;
			case MENU_CHOICE.trainee:
//				traineeMenu();
				break;
			case MENU_CHOICE.exit:
				System.out.println("프로그램을 종료합니다.");
				flag = true;
				break;
			default :
				System.out.println("해당 메뉴 번호만 입력하세요.");
			}
		}catch(Exception e) {
			System.out.println("오류가 있습니다. 프로그램을 다시시작하세요");
			return;
		}
		}

	}

	public static void subjectMenu() throws Exception {
		SubjectRegisterManager subjectManager = new SubjectRegisterManager();
		MenuView.subjectMenuView();
		int choice = MenuView.scan.nextInt();
		MenuView.scan.nextLine();
		
		switch(choice) {
		case SUBJECT_CHOICE.LIST :
			System.out.println("");
			subjectManager.subjectList();
			break;
		case SUBJECT_CHOICE.INSERT :
			System.out.println("");
			subjectManager.subjectRegister();
			break;
		case SUBJECT_CHOICE.UPDATE :
			subjectManager.subjectUpdate();
			break;
		case SUBJECT_CHOICE.DELETE :
			System.out.println("");
			subjectManager.subjectDelete();
			break;
		case SUBJECT_CHOICE.MAIN :
			return;
		default : 
			System.err.println("해당 메뉴 번호만 입력하세요.");
		}
	}

//	public static void studentMenu() {
//		 TODO Auto-generated method stub
//		
//	}
//
//	public static void lessonMenu() {
//		 TODO Auto-generated method stub
//		
//	}
//
//	public static void traineeMenu() throws Exception{
//		TraineeRegisterManager traineeManager = new TraineeRegisterManager();
//		MenuView.traineeMenuView();
//		int num = MenuView.scan.nextInt();
//		
//		switch(num) {
//		case TRAINEE_CHOICE.LIST :
//			System.out.println("");
//			traineeManager.traineeList();
//		
//		}
//		
//	}
}
	
