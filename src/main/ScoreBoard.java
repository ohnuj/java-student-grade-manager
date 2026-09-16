package main;

import java.util.Scanner;
import func.Funcs;


public class ScoreBoard {

	public static void main(String[] args) {
		Funcs funcs = new Funcs();
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		String menu [] = {"1. 학생입력(이름,나이)","2. 성적입력(과목,점수)","3. 성적표 조회","4. 정보변경(이름,나이,과목,성적)",
				"5. 정보 삭제(학생,성적)", "6. 평균 조회(전체,학생별,과목별)", "7. 등수 조회(전체,과목별)","10. 종료"};
		
		while (check) {
			String bar = "-";
			System.out.println(bar.repeat(30));
			for (int i = 0; i<menu.length;i++) {
				System.out.println(menu[i]);
			}
			System.out.println(bar.repeat(30));
			int x = funcs.check_num(sc);
			switch (x) {
			case 1:
				funcs.input_student();
				break;
			case 2:
				funcs.input_subject();
				break;
			case 3:
				funcs.print_scoreBoard();
				break;
			case 4:
				funcs.print_scoreBoard();
				System.out.println("1. 이름변경 2. 나이변경 3. 과목명 변경 4. 성적 변경");
				x = funcs.check_num(sc);
				switch (x) {
				case 1:
					funcs.alter_name();
					break;
				case 2:
					funcs.alter_age();
					break;
				case 3:
					funcs.alter_subjectName();
					break;
				case 4:
					funcs.alter_score();
					break;

				default:
					System.out.println("다시 입력하세요");
					break;
				}
				break;
			case 5:
				funcs.print_scoreBoard();
				System.out.println("1. 학생 삭제 2. 성적 삭제");
				x = funcs.check_num(sc);
				switch (x) {
				case 1:
					funcs.delete_student();
					break;
				case 2:
					funcs.delete_score();
					break;
					
				default:
					System.out.println("다시 입력하세요");
					break;
				}
				break;
			case 6:
				System.out.println("1. 전체 평균 2. 학생 평균 3. 과목별 평균");
				x = funcs.check_num(sc);
				switch (x) {
				case 1:
					funcs.avg_allStudent();
					break;
				case 2:
					funcs.avg_eachStudent();
					break;
				case 3:
					funcs.avg_eachSubject();
					break;
				case 4:
					funcs.avg_Subject();
					break;
					
				default:
					System.out.println("다시 입력하세요");
					break;
				}
				break;
			case 7:
				System.out.println("1. 전체 등수 2. 과목별 등수");
				x = funcs.check_num(sc);
				switch (x) {
				case 1:
					funcs.ranking_allStudent();
					break;
				case 2:
					funcs.ranking_subject();
					break;
					
				default:
					System.out.println("다시 입력하세요");
					break;
				}
				break;
			case 10:
				check = false;
				System.out.println("종료합니다");
				break;
			case 50:
				funcs.saveToFile();
				break;
			case 51:
				funcs.LoadToFile();
				break;
			default:
				System.out.println("다시 입력하세요");
				break;
			}

		}

	}

}
