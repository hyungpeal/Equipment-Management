# Equipment Management
Problem: 학과 사무실에서 기자재를 대여, 반납 시 기록을 수기로 진행. 이로 인해 생기는 문제점들
<ul>
  <li>대여 및 반납 과정을 불편함</li>
  <li>오작성 문제 발생</li>
  <li>자료 관리의 불편함</li>
</ul>

Idea: "모든게 자동화 되고 전자기기를 사용하는 때 인데 편리하게 사용할 수 있는 프로그램을 만들어보자"

Solution: 수기 기록 방식을 웹으로 대체.

## 주요 기능
<ul>
  <li><b>기자재 검색</b></li>: 기자재의 이름과 카테고리를 입력하면 그에 맞는 결과를 보여줌
  <li><b>기자재 등록</b></li>: 기자재의 정보(바코드, 등록일자, 기자재명, 이미지 등)을 입력해 저장
  <li><b>대여 & 반납</b></li>: 기자재의 대여 기록을 확인해 대여 또는 반납하는 기능
  <li><b>대여자 출력</b></li>: 현재 대여중인 사람과 이미 반납을 완료한 사람들의 리스트를 출력
  <li><b>배포</b></li>: jar 파일로 빌드 후 실행 파일로 만들어 배포
  <li><b>DB</b></li>: 실행파일에 내장할 수 있는 SQLite를 사용
</ul>

## 메인 로직 1. 기자재 등록
1. 등록에 필요한 정보 정하기
<table>
  <tr>
    <th scope="col" colspan="7"><b>기자재 등록 정보</b></th>
  </tr>
  <tr>
    <td>바코드 번호</td>
    <td>등록일자</td>
    <td>카테고리</td>
    <td>기자재명</td>
    <td>이미지</td>
    <td>비고</td>
    <td>보관장소</td>
  </tr>
</table>
2. 이미지는 사용자의 로컬에 저장하도록 설정
C: 하위에 uploaded-images 폴더를 생성함

## 메인 로직 2. 다중 검색 & 정렬
1. 기자재명과 카테고리 둘 중 어느 것을 입력해도 검색이 됨
2. 기자재명 정렬 버튼을 통해 가나다순으로 정렬
3. 대여일자별 정렬 버튼을 통해 날짜순으로 정렬
4. 남은 기준 정렬 버튼을 통해 반납 기간으로 정렬

## 기술 스택
Front
<ul>
  <li>BootStrap</li>
</ul>
<img alt="bootstrap" width="240" height="189" src="https://github.com/user-attachments/assets/7a3c6905-f763-44c6-9905-3250bfe83df4">

Back
<ul>
  <li>Spring Boot & SQLite</li>
</ul>
<img alt="spring" width="443" height="190" src="https://github.com/user-attachments/assets/7d920280-b34b-4c02-ba10-ba250c5c394e"><img alt="sqlite" width="401" height="190" src="https://github.com/user-attachments/assets/590d790f-63b5-4603-b1cb-deaad734f995">

## 개발 기간
<ul>
  <li>
    2024.09.11. ~ 12.10. (3개월)
  </li>
</ul>

## 기획 & 설계
<ul>
<li><a href="https://drive.google.com/file/d/1seufwAtzI3jLEyzqY9_fAZnoSox29NLJ/view?usp=sharing">전체 시스템 설계</a></li>
<li><a href="https://www.figma.com/design/BhaJw5hcDToFAqGsMA3r88/main?node-id=0-1&t=8SMGPE5hbZPxDjtm-1">초기 디자인 설계</a></li>
<li>다운로드: https://drive.google.com/file/d/1S-bP0VBLK9NmFKPXvXYaII-OrW_lQlgb/view?usp=drive_link</li>
</ul>

![DB](https://github.com/user-attachments/assets/fc3adc7b-801f-4b52-ba6c-c124c593b18a)

## 주의점
JDK21 이상에서 실행
