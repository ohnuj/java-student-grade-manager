package func;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import DTO.StudentDTO;
import DTO.SubjectDTO;

public class Funcs {

	Scanner sc = new Scanner(System.in);
	ArrayList<StudentDTO> students = new ArrayList<StudentDTO>();

	public int check_num(Scanner sc) {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				return 0;
			}
		}
	}

	public void saveToFile() {
		try (FileWriter fw = new FileWriter("students.txt")) {
			for (StudentDTO st : students) {
				StringBuilder sb = new StringBuilder();

				// 학생 이름, 나이 저장
				sb.append(st.getName());
				sb.append(",");
				sb.append(st.getAge());

				// 과목 저장
				for (SubjectDTO sub : st.getSubject()) {
					sb.append(",");
					sb.append(sub.getSubjectName());
					sb.append(":");
					sb.append(sub.getScore());
				}
				fw.write(sb.toString() + "\n");
			}
			System.out.println("저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void LoadToFile() {
		try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {

			String line;

			while ((line = br.readLine()) != null) {
				String arr[] = line.split(",");

				// arr[0] => st_name;
				// arr[1] => 수학:90
				// arr[2] => 과학:70 ... arr[n]
				StudentDTO s = new StudentDTO();

				s.setName(arr[0]);
				s.setAge(Integer.parseInt(arr[1]));

				for (int i = 2; i < arr.length; i++) {
					String arr2[] = arr[i].split(":");
					// arr2[0] = 수학
					// arr2[1] = 90 ( String )
					String sub_name = arr2[0];
					int sub_score = Integer.parseInt(arr2[1]);

					SubjectDTO sub = new SubjectDTO();
					sub.setSubjectName(sub_name);
					sub.setScore(sub_score);

					s.getSubject().add(sub);
				}
				students.add(s);
			}
			System.out.println("로드 완료!");
		} catch (IOException e) {
			System.out.println("저장된 파일이 없습니다.");
		}
	}

	public void input_student() {
		System.out.println("이름 : ");
		String name = sc.nextLine();

		for (int i = 0; i < students.size(); i++) {
			if (name.equals(students.get(i).getName())) {
				System.out.println("이미 입력된 이름입니다");
				return;
			}
		}
		System.out.println("나이 : ");
		int age = check_num(sc);

		StudentDTO student = new StudentDTO();
		student.setName(name);
		student.setAge(age);
		students.add(student);
	}

	public void input_subject() {
		boolean check = true;
		while (check) {
			System.out.println("누구의 성적을 입력할까요?");
			String name = sc.nextLine();
			for (int i = 0; i < students.size(); i++) {
				if (name.equals(students.get(i).getName())) {
					System.out.println("몇개의 과목을 입력할까요?");
					int n = check_num(sc);
					for (int j = 0; j < n; j++) {
						System.out.println("과목명 : ");
						String subjectName = sc.nextLine();

						boolean check_subject = false;
						for (int k = 0; k < students.get(i).getSubject().size(); k++) {
							if (subjectName.equals(students.get(i).getSubject().get(k).getSubjectName())) {
								System.out.println("이미 입력된 과목입니다.");
								check_subject = true;
								break;
							}
						}
						if (check_subject) {
							j = j - 1;
							continue;
						}
						boolean check_score = true;
						while (check_score) {
							System.out.println("점수 : ");
							int score = check_num(sc);
							if (score >= 0 && score <= 100) {
								SubjectDTO subject = new SubjectDTO();
								subject.setSubjectName(subjectName);
								subject.setScore(score);
								students.get(i).getSubject().add(subject);
								check = false;
								check_score = false;
							} else {
								System.out.println("0~100점 사이에서 입력하세요.");
								continue;
							}
						}
					}
				}
			}
			if (check == true) {
				System.out.println("없는 이름입니다. 다시 입력하세요");
			}
		}
	}

	public void print_scoreBoard() {
		String a = "*";
		System.out.println(a.repeat(30));
		for (int i = 0; i < students.size(); i++) {
			System.out.printf("%d번 이름 : %s, 나이 : %d \n", i + 1, students.get(i).getName(), students.get(i).getAge());
			for (int j = 0; j < students.get(i).getSubject().size(); j++) {
				System.out.printf("\t%s : %d\n", students.get(i).getSubject().get(j).getSubjectName(),
						students.get(i).getSubject().get(j).getScore());
			}
		}
		System.out.println(a.repeat(30));
	}

	public void alter_name() {
		while (true) {
			boolean check = true;

			System.out.println("누구의 이름을 바꿀까요?");
			String name = sc.nextLine();
			for (int i = 0; i < students.size(); i++) {
				if (name.equals(students.get(i).getName())) {
					System.out.println("어떤 이름으로 바꿀까요?");
					String new_name = sc.nextLine();
					students.get(i).setName(new_name);
					check = false;
					return;
				}
			}
			if (check == true) {
				System.out.println("없는 이름입니다. 다시 입력하세요");
			}

		}
	}

	public void alter_age() {
		while (true) {
			boolean check = true;

			System.out.println("누구의 나이를 바꿀까요?");
			String name = sc.nextLine();
			for (int i = 0; i < students.size(); i++) {
				if (name.equals(students.get(i).getName())) {
					System.out.println("몇살로 바꿀까요?");
					students.get(i).setAge(sc.nextInt());
					check = false;
					return;
				}
			}
			if (check == true) {
				System.out.println("없는 이름입니다. 다시 입력하세요");
			}
		}

	}

	public void alter_subjectName() {
		while (true) {
			System.out.println("누구의 성적 과목을 바꿀까요?");
			String name = sc.nextLine();
			boolean check_name = true;
			for (int i = 0; i < students.size(); i++) {
				if (name.equals(students.get(i).getName())) {
					check_name = false;
					while (true) {
						System.out.println("어떤 과목을 바꿀까요?");
						String subjectName = sc.nextLine();
						boolean check_subject = true;

						for (int j = 0; j < students.get(i).getSubject().size(); j++) {
							if (subjectName.equals(students.get(i).getSubject().get(j).getSubjectName())) {
								System.out.println("어떤 과목으로 바꿀까요?");
								String new_subjectName = sc.nextLine();
								students.get(i).getSubject().get(j).setSubjectName(new_subjectName);

								check_subject = false;
								return;
							}

						}

						if (check_subject == true)
							System.out.println("없는 과목입니다. 다시 입력하세요");
					}
				}
			}

			if (check_name == true)
				System.out.println("없는 이름입니다. 다시 입력하세요");
		}

	}

	public void alter_score() {
		while (true) {
			System.out.println("누구의 성적을 바꿀까요?");
			String name = sc.nextLine();
			boolean check_name = true;
			for (int i = 0; i < students.size(); i++) {
				if (name.equals(students.get(i).getName())) {
					check_name = false;
					while (true) {
						System.out.println("어떤 과목을 바꿀까요?");
						String subjectName = sc.nextLine();
						boolean check_subject = true;

						for (int j = 0; j < students.get(i).getSubject().size(); j++) {
							if (subjectName.equals(students.get(i).getSubject().get(j).getSubjectName())) {
								System.out.println("몇점으로 바꿀까요?");
								int new_score = check_num(sc);
								students.get(i).getSubject().get(j).setScore(new_score);

								check_subject = false;
								return;
							}

						}

						if (check_subject == true)
							System.out.println("없는 과목입니다. 다시 입력하세요");
					}
				}
			}

			if (check_name == true)
				System.out.println("없는 이름입니다. 다시 입력하세요");
		}

	}

	public void delete_student() {
		while (true) {
			boolean check = true;

			System.out.println("누구의 이름을 삭제할까요?");
			String name = sc.nextLine();
			for (int i = 0; i < students.size(); i++) {
				if (name.equals(students.get(i).getName())) {
					students.remove(i);
					check = false;
					return;
				}
			}
			if (check == true) {
				System.out.println("없는 이름입니다.다시 입력하세요");
			}

		}
	}

	public void delete_score() {
		while (true) {
			System.out.println("누구의 성적 과목을 삭제할까요?");
			String name = sc.nextLine();
			boolean check_name = true;
			for (int i = 0; i < students.size(); i++) {
				if (name.equals(students.get(i).getName())) {
					check_name = false;
					while (true) {
						System.out.println("어떤 과목을 삭제할까요?");
						String subjectName = sc.nextLine();
						boolean check_subject = true;

						for (int j = 0; j < students.get(i).getSubject().size(); j++) {
							if (subjectName.equals(students.get(i).getSubject().get(j).getSubjectName())) {

								students.get(i).getSubject().remove(j);

								check_subject = false;
								return;
							}

						}

						if (check_subject == true)
							System.out.println("없는 과목입니다. 다시 입력하세요");
					}
				}
			}

			if (check_name == true)
				System.out.println("없는 이름입니다. 다시 입력하세요");
		}

	}

	public double avg_allStudent() {
		double avg = 0;
		double sum = 0;
		int count = 0;
		for (int i = 0; i < students.size(); i++) {
			for (int j = 0; j < students.get(i).getSubject().size(); j++) {
				sum += students.get(i).getSubject().get(j).getScore();
				count++;
			}
			avg = sum / count;
		}
		System.out.printf("전체 평균 : %.2f\n", avg);
		return avg;
	}

	public double avg_eachStudent() {
		double avg = 0;
		for (int i = 0; i < students.size(); i++) {
			double sum = 0;
			for (int j = 0; j < students.get(i).getSubject().size(); j++) {
				sum += students.get(i).getSubject().get(j).getScore();
			}
			avg = sum / students.get(i).getSubject().size();
			System.out.printf("%s의 평균 : %.2f\n", students.get(i).getName(), avg);
		}
		return avg;
	}

	public double avg_eachSubject() {
		double avg = 0;
		double sum = 0;
		int count = 0;

		while (true) {
			System.out.println("어떤 과목의 평균을 보시겠습니까?");
			String subject = sc.nextLine();
			for (int i = 0; i < students.size(); i++) {
				for (int j = 0; j < students.get(i).getSubject().size(); j++) {
					if (subject.equals(students.get(i).getSubject().get(j).getSubjectName())) {
						sum += students.get(i).getSubject().get(j).getScore();
						count++;
					}
				}

			}
			avg = sum / count;
			System.out.printf("%s의 평균 : %.2f\n", subject, avg);
			return avg;
		}

	}

	public double avg_Subject() {
		double avg = 0;
		double sum = 0;
		int count = 0;

		while (true) {
			System.out.println("어떤 과목의 평균을 보시겠습니까?");
			String subject = sc.nextLine();
			for (int i = 0; i < students.size(); i++) {
				for (int j = 0; j < students.get(i).getSubject().size(); j++) {
					if (subject.equals(students.get(i).getSubject().get(j).getSubjectName())) {
						sum += students.get(i).getSubject().get(j).getScore();
						count++;
					}
				}

			}
			avg = sum / count;
			System.out.printf("%s의 평균 : %.2f\n", subject, avg);
			return avg;
		}
	}

	public void ranking_allStudent() {
		double avg = 0;
		double avgs[] = new double[students.size()];
		int ranks[] = new int[avgs.length];
		for (int i = 0; i < students.size(); i++) {
			double sum = 0;
			for (int j = 0; j < students.get(i).getSubject().size(); j++) {
				sum += students.get(i).getSubject().get(j).getScore();
			}
			avg = sum / students.get(i).getSubject().size();
			avgs[i] = avg;
		}
		for (int i = 0; i < students.size(); i++) {
			int rank = 1;
			for (int j = 0; j < students.size(); j++) {
				if (avgs[i] < avgs[j])
					rank++;
			}
			ranks[i] = rank;
		}
		for (int rank = 1; rank <= students.size(); rank++) {
			for (int i = 0; i < students.size(); i++) {
				if (ranks[i] == rank) {
					System.out.printf("%d등 %s %.2f\n", rank, students.get(i).getName(), avgs[i]);
				}
			}
		}
	}

	public void ranking_subject() {
		int scores[] = new int[students.size()];
		int ranks[] = new int[scores.length];
		System.out.println("과목을 입력하세요");
		String subject = sc.nextLine();
		for (int i = 0; i < students.size(); i++) {
			for (int j = 0; j < students.get(i).getSubject().size(); j++) {
				if (subject.equals(students.get(i).getSubject().get(j).getSubjectName()))
					scores[i] += students.get(i).getSubject().get(j).getScore();
			}

		}
		for (int i = 0; i < students.size(); i++) {
			int rank = 1;
			for (int j = 0; j < students.size(); j++) {
				if (scores[i] < scores[j])
					rank++;
			}
			ranks[i] = rank;
		}
		for (int rank = 1; rank <= students.size(); rank++) {
			for (int i = 0; i < students.size(); i++) {
				if (ranks[i] == rank) {
					System.out.printf("%d등 %s %d\n", rank, students.get(i).getName(), scores[i]);
				}
			}
		}
	}
}