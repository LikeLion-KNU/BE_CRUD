# 🦁 12th LIKELION CRUD Assignment

## 📮 진행 방법
### 1. 로컬 환경 (바탕화면 등...)에 클론 진행 및 해당 디렉토리 진입
```BASH
# 다운로드
git clone https://github.com/LikeLion-KNU/BE_CRUD

# 해당 디렉토리 진입
cd BE_CRUD
```
### 2. 브랜치 생성: Team_팀번호_이름 - (ex. Team_0_jiwoong)
- 아이디어톤 팀 번호로 진행 (나중에 제출확인 용이하게 하기 위함.)
```BASH
# 브랜치 생성
git branch Team_0_name

# 생성한 브랜치로 이동
git checkout Team_0_name

# 현재 브랜치 확인
git branch
```
### 3. 스프링 MYSQL 연결 & JPA를 활용한 아래 ERD CRUD구현

<img width="1000" alt="Untitled" src="https://github.com/LikeLion-KNU/BE_CRUD/assets/100078615/c3266d25-7167-4766-b791-6a1ab0f4b194">

- MYSQL은 로컬 환경에서 쓰시는 방법대로 해주시면 됩니다!
- 본인 브랜치에 중간중간 ```commit```을 남겨주세요!
- ```commit convention```은 하고싶으신대로 해주세요.
> ‼️ 꼭 ```commit```하시고 본인 브랜치에 ```push```해주셔야합니다 ‼️
```bash
# 본인 브랜치에 push
git push origin Team_0_name
```
### 4. CRUD 완료시 아래 형식에 맞춰서 API 명세서 작성
> Entity(해당 Entity name) API
> 1. 기능명
> + 엔드 포인트 :
> + 설명 :
> + 요청 본문 :
> ```json
>{
>   "entity": "type",
>}
> ```
> + 응답 :
---

## Member API

### 1. 회원 생성
- **엔드포인트**: `POST /members`
- **설명**: 새로운 회원을 생성합니다.
- **요청 본문**:
    ```json
    {
      "email": "string",
      "password": "string",
      "role": "ADMIN 또는 USER",
      "name": "string",
      "age": "number",
      "isAccountExpired": "boolean",
      "isAccountLocked": "boolean"
    }
    ```
- **응답**: `memberId`를 포함한 Member 객체를 반환합니다.

### 2. 모든 회원 조회
- **엔드포인트**: `GET /members`
- **설명**: 모든 회원 목록을 조회합니다.
- **응답**: Member 객체 리스트.

### 3. 회원 조회
- **엔드포인트**: `GET /members/{id}`
- **설명**: 특정 ID를 가진 회원을 조회합니다.
- **요청 본문**: 없음
- **응답**: `memberId`를 포함한 Member 객체를 반환합니다.

### 4. 회원 수정
- **엔드포인트**: `PUT /members/{id}`
- **설명**: 특정 ID를 가진 회원 정보를 수정합니다.
- **요청 본문**:
    ```json
    {
      "email": "string",
      "password": "string",
      "role": "ADMIN 또는 USER",
      "name": "string",
      "age": "number",
      "isAccountExpired": "boolean",
      "isAccountLocked": "boolean"
    }
    ```
- **응답**: 수정된 Member 객체를 반환합니다.

### 5. 회원 삭제
- **엔드포인트**: `DELETE /members/{id}`
- **설명**: 특정 ID를 가진 회원을 삭제합니다.
- **요청 본문**: 없음
- **응답**: 삭제 확인 메시지를 반환합니다.

## Coupon API

### 1. 쿠폰 생성
- **엔드포인트**: `POST /coupons`
- **설명**: 새로운 쿠폰을 생성합니다.
- **요청 본문**:
    ```json
    {
      "type": "PERCENTAGE 또는 FIXED_AMOUNT",
      "discount": "number",
      "issueDate": "datetime",
      "expirationDate": "datetime"
    }
    ```
- **응답**: `couponId`를 포함한 Coupon 객체를 반환합니다.

### 2. 쿠폰 조회
- **엔드포인트**: `GET /coupons/{id}`
- **설명**: 특정 ID를 가진 쿠폰을 조회합니다.
- **요청 본문**: 없음
- **응답**: `couponId`를 포함한 Coupon 객체를 반환합니다.

### 3. 쿠폰 수정
- **엔드포인트**: `PUT /coupons/{id}`
- **설명**: 특정 ID를 가진 쿠폰 정보를 수정합니다.
- **요청 본문**:
    ```json
    {
      "type": "PERCENTAGE 또는 FIXED_AMOUNT",
      "discount": "number",
      "issueDate": "datetime",
      "expirationDate": "datetime"
    }
    ```
- **응답**: 수정된 Coupon 객체를 반환합니다.

### 4. 쿠폰 삭제
- **엔드포인트**: `DELETE /coupons/{id}`
- **설명**: 특정 ID를 가진 쿠폰을 삭제합니다.
- **요청 본문**: 없음
- **응답**: 삭제 확인 메시지를 반환합니다.

## CouponHolders API

### 1. 쿠폰 소유자 생성
- **엔드포인트**: `POST /couponHolders`
- **설명**: 새로운 쿠폰 소유자를 생성합니다.
- **요청 본문**:
    ```json
    {
      "couponId": "number",
      "memberId": "number"
    }
    ```
- **응답**: `memberCouponId`를 포함한 CouponHolders 객체를 반환합니다.

### 2. 쿠폰 소유자 조회
- **엔드포인트**: `GET /couponHolders/{id}`
- **설명**: 특정 ID를 가진 쿠폰 소유자를 조회합니다.
- **요청 본문**: 없음
- **응답**: `memberCouponId`를 포함한 CouponHolders 객체를 반환합니다.

### 3. 쿠폰 소유자 수정
- **엔드포인트**: `PUT /couponHolders/{id}`
- **설명**: 특정 ID를 가진 쿠폰 소유자 정보를 수정합니다.
- **요청 본문**:
    ```json
    {
      "couponId": "number",
      "memberId": "number"
    }
    ```
- **응답**: 수정된 CouponHolders 객체를 반환합니다.

### 4. 쿠폰 소유자 삭제
- **엔드포인트**: `DELETE /couponHolders/{id}`
- **설명**: 특정 ID를 가진 쿠폰 소유자를 삭제합니다.
- **요청 본문**: 없음
- **응답**: 삭제 확인 메시지를 반환합니다.

---
### 5. 노션에 본인 브랜치 URL 제출
✅ [본인 브랜치 URL 제출 링크](https://www.notion.so/CRUD-f59053587cd74f4ab5fca7841d5fac83?pvs=4)

### 6. 끝~!
<img width="250" alt="Untitled" src="https://cdn.sketchpan.com/member/e/exosm12/draw/1454491678758/0.png">
