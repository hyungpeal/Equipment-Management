# Equipment Management System

학과 사무실 및 소규모 조직에서 사용하는 **기자재 대여·반납 관리 시스템**입니다.

기존 수기 관리 방식에서 발생하던 **입력 오류, 관리 누락, 조회 불편** 문제를 개선하기 위해 개발했습니다.

Java와 Spring Boot를 기반으로 구현했으며,

별도의 서버 환경 없이 실행 가능한 **로컬 실행형 데스크탑 애플리케이션**을 목표로 설계했습니다.

---

## Project Overview

- **목적**
    
    기자재 대여·반납 과정을 시스템화하여
    
    관리 효율성과 데이터 정확성을 향상시키는 것
    
- **개발 형태**
    
    개인 프로젝트
    
- **개발 기간**
    
    2024.09 – 2024.12
    

---

## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Database:** SQLite
- **Build & Run:** JAR → EXE (Launch4j)
- **UI:** Bootstrap 기반 화면 구성

---

## Key Features

### 기자재 관리

- 기자재 등록, 수정, 삭제 기능
- 바코드 기반 기자재 식별 구조 설계
- 이름 및 카테고리 기준 기자재 검색 기능

### 대여·반납 관리

- 기자재 대여 및 반납 처리 기능
- 대여 상태(대여 가능 / 대여 중) 관리
- 현재 대여 중인 기자재 및 사용자 목록 조회

### 데이터 관리

- SQLite 로컬 데이터베이스 사용
- 별도 DB 서버 없이 실행 가능하도록 구성
- 애플리케이션 종료 후에도 데이터 유지

---

## System Design

- **Spring Boot 기반 계층 구조**
    - Controller → Service → Repository 구조로 역할 분리
    - 비즈니스 로직과 UI 로직 분리를 통해 유지보수성 확보
- **Entity 설계**
    - Equipment: 기자재 정보 및 상태 관리
    - Rental: 대여·반납 이력 관리
    - Customer: 대여 사용자 정보 관리
- **상태 관리 방식**
    - 기자재 상태를 명확히 구분하여 중복 대여 방지
    - 대여 및 반납 시 Equipment 상태 자동 갱신

---

## Technical Decisions

### SQLite 선택 이유

- 별도의 데이터베이스 설치가 필요 없음
- 소규모 조직 및 개인 사용 환경에 적합
- 배포 및 유지보수 비용 최소화

### Launch4j 기반 EXE 배포

- JAR 파일을 Windows 실행 파일(.exe)로 변환
- 콘솔 창 없이 GUI 애플리케이션으로 실행 가능
- 개발 환경이 없는 사용자도 쉽게 실행 가능하도록 고려

---

## How to Run (Windows)

본 프로젝트는 **Launch4j를 사용하여 JAR 파일을 Windows 실행 파일(.exe)로 변환**했습니다.

명령어 입력 없이 실행 파일을 통해 바로 사용할 수 있습니다.

### 실행 방법

URL 에서 실행 파일을 다운로드 합니다.

https://drive.google.com/file/d/1S-bP0VBLK9NmFKPXvXYaII-OrW_lQlgb/view?usp=drive_link

1. 해당 파일을 더블 클릭하여 애플리케이션을 실행합니다.
2. 실행 후 UI를 통해 기자재 등록, 대여 및 반납 기능을 사용할 수 있습니다.

---

### 실행 환경

- **운영체제:** Windows
- **Java Runtime:** JRE 설치 필요 (Java 21 이상 권장)
- **Database:** SQLite (애플리케이션 내장, 별도 설정 불필요)

---

### 참고 사항

- C:\ 에 SQLite DB 파일이 생성됩니다.
- 애플리케이션 종료 후에도 데이터는 유지됩니다.
- 최초 실행 시 Windows 보안 경고가 표시될 수 있습니다.

---

## What I Learned

- Spring Boot 기반 애플리케이션의 전체 구조와 실행 흐름 이해
- RDB 기반 데이터 모델링 및 JPA 활용 경험
- 실제 사용 환경을 고려한 **로컬 실행형 시스템 설계 경험**
- 기능 구현뿐 아니라 **배포 방식과 사용자 접근성**의 중요성 인식

---

## Future Improvements (Optional)

- 대여 이력 통계 및 기간별 조회 기능 추가
- 사용자 권한 분리(관리자 / 일반 사용자)
- UI/UX 개선 및 반응형 레이아웃 적용
