# MSA Authorization Boilerplate

## 🚊 개요

- 주제: 인증 시스템
- 기간: ~ 2023.12

## 🛍️ 요구 사항
- 가입, 로그인 페이지
- 유저관리 페이지
- 인증 서버 API
- RDBMS DB 사용 : MySQL, MariaDB, PostgreSQL
- Password Encryption
- E-Mail 인증 (option)
- 비밀번호 찾기 (option)
- 캐시 (option)

## 🏈 현재 상황

### Frontend
- Vue.js를 활용한 웹 프로젝트 경험 有

### Backend
- Spring Security 6.x 활용 경험 有
- Spring Security 없이 인증/인가 시스템 구현한 경험 有
    - Filter를 통한 사용자 정보 임의 처리
    - Custom Annotation과 Resolver를 통한 사용자 객체 처리
- OpenFeign을 활용하여 마이크로 서비스 간의 HTTP 통신만 경험해본 상태
- TDD을 도전하였지만, 끝날 무렵에는 일정에 쫓겨 테스트 코드 작성을 생략
- 이메일 인증 구현 경험 有
- 이메일을 활용한 임시 비밀번호 발급 경험 有

## 🍔 목표 설정
<aside>
💡 의사결정을 할 수 있는 다양한 근거 경험하기

</aside>

### Frontend
- Vue.js를 활용한 웹 프로젝트 구현

### Backend
- Access Token, Refresh Token 시스템 구현하기
- MSA에서의 인증/인가 API 구현하기
    - Netfilx Eureka와 gRPC를 활용하여 MSA 시스템 구성하기
    - Passport(내부 토큰) 구현하기
- TDD 방식으로 개발하기
- 메시지 브로커 활용하기
- 캐시 적용하기

## 👁️‍🗨️ 아키텍처 초안
![image](https://github.com/210-reverof/msa-authoriazation-boiler-plate/assets/74983448/178433b6-2369-4de1-8a59-052e9e7aab04)


## 🍵 일정
팀 프로젝트 및 이외 활동이 많은 12월임을 감안하여 러프하게 계획 수립
- 회원 가입 페이지 (~12.13)
- 회원 가입 API (~12.15)
- 로그인 페이지 (~12.28)
- 로그인 API (~12.20)
- 유저관리 페이지 (~12.23)
- 유저관리 API (~12.27)
