기술
1. Exception : @ControllerAdvice를 통하여 Exception을 관리하고, CommonResponse.java, ErrorCode로 커스텀한 응답 표출
2. Logging : @Slf4j를 이용한 로깅
3. JPA : 기본 조회 및 저장
4. MariaDB : 로컬 MariaDB 연동
5. Security
  - CSRF 방지
  - HTTP Header 보안
  - 설정파일 암호화(jasypt)
6. Authentication
   - OAuth2.0 적용

Functions
1. Todo item 추가
2. Todo list 조회

Table
- id : ID
- token : 외부 조회용
- title : 타이틀
- expectedDate : 완료 예상 날짜
- createdAt : 생성 날짜
- updatedAt : 수정 날짜