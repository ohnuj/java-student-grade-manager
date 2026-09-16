# 🎓 Java Student Grade Manager

Java를 처음 학습하면서 제작한 **콘솔 기반 학생 성적 관리 프로그램**입니다.

별도의 데이터베이스 없이 Java 객체와 `ArrayList`를 이용하여  
학생 정보와 과목별 성적을 등록·조회·수정·삭제하고,  
평균 및 등수를 계산하는 기능을 구현했습니다.

Java의 기본 문법부터 클래스와 객체, 컬렉션, 반복문, 조건문, 파일 입출력 등을
직접 활용해보기 위해 제작한 초기 학습 프로젝트입니다.

---

## 🛠 Tech Stack

- **Language** : Java
- **Development Environment** : Eclipse
- **Data Storage** : ArrayList / Text File

---

## ✨ Main Features

### 👤 학생 관리

- 학생 이름 및 나이 등록
- 학생 정보 조회
- 학생 이름 변경
- 학생 나이 변경
- 학생 삭제
- 동일한 이름의 학생 중복 등록 방지

---

### 📚 성적 관리

- 학생별 과목 및 점수 등록
- 동일 학생의 과목 중복 등록 방지
- 점수 입력 범위 검증 (`0 ~ 100`)
- 과목명 변경
- 성적 변경
- 과목별 성적 삭제

---

### 📊 평균 계산

- 전체 학생 성적 평균
- 학생별 평균
- 특정 과목 평균

학생과 과목 정보를 반복문으로 순회하면서
점수 합계와 데이터 개수를 직접 계산하여 평균을 구하도록 구현했습니다.

---

### 🏆 등수 계산

- 학생 전체 평균 기준 등수
- 특정 과목 기준 등수

학생들의 점수를 배열에 저장한 뒤 서로 비교하여
등수를 직접 계산하도록 구현했습니다.

---

## 💾 File Save / Load

데이터베이스를 사용하지 않고 `FileWriter`와 `BufferedReader`를 이용하여  
학생 정보와 성적을 `students.txt` 파일에 저장하고 다시 불러올 수 있도록 구현했습니다.

저장 데이터는 다음과 같은 형태로 관리됩니다.

```text
학생이름,나이,과목:점수,과목:점수
```

예시:

```text
홍길동,20,수학:90,영어:85
김철수,21,수학:75,영어:95
```

이를 통해 Java의 기본 파일 입출력과 문자열 분리 과정을 학습했습니다.

---

## 🗂 Project Structure

```text
src
├─ main
│  └─ ScoreBoard.java
│
├─ func
│  └─ Funcs.java
│
└─ DTO
   ├─ StudentDTO.java
   └─ SubjectDTO.java
```

### 주요 역할

| 구성 | 역할 |
|---|---|
| `ScoreBoard` | 프로그램 실행 및 콘솔 메뉴 제어 |
| `Funcs` | 학생·성적 관리 및 평균·등수 계산 |
| `StudentDTO` | 학생 정보 저장 |
| `SubjectDTO` | 과목 및 점수 정보 저장 |

---

## 💡 Data Structure

학생 정보는 `ArrayList<StudentDTO>`를 이용하여 관리했습니다.

```java
ArrayList<StudentDTO> students = new ArrayList<StudentDTO>();
```

각 학생 객체 내부에서 여러 개의 과목과 점수를 관리하도록 구성하여  
한 명의 학생이 여러 과목을 가질 수 있도록 구현했습니다.

```text
Student
 ├─ name
 ├─ age
 └─ subjects
      ├─ Subject
      │   ├─ subjectName
      │   └─ score
      │
      └─ Subject
          ├─ subjectName
          └─ score
```

---

## 📚 What I Learned

이 프로젝트를 통해 다음 Java 기초 내용을 연습했습니다.

- 변수와 자료형
- 조건문 (`if`, `switch`)
- 반복문 (`for`, `while`)
- 메서드 작성 및 호출
- 클래스와 객체
- DTO를 이용한 데이터 관리
- `ArrayList` 활용
- 배열을 이용한 데이터 비교
- 문자열 비교 및 처리
- 사용자 입력 처리 (`Scanner`)
- 예외 처리 (`try-catch`)
- 파일 입출력 (`FileWriter`, `BufferedReader`)
- 학생별 / 과목별 데이터 탐색
- 평균 및 등수 계산 로직 구현

---

## 🌱 Project Meaning

Java를 처음 학습하면서 만든 **초기 콘솔 프로젝트**입니다.

데이터베이스나 프레임워크를 사용하지 않고 Java의 기본 기능만을 이용하여  
여러 학생과 과목 데이터를 객체로 관리하고, 직접 데이터를 탐색하고 계산하는 과정을 경험했습니다.

이 프로젝트를 통해 Java의 기본 문법과 객체 활용에 익숙해졌으며,  
이후 JDBC를 이용한 데이터베이스 연동과 백엔드 개발을 학습하는 기초가 되었습니다.
