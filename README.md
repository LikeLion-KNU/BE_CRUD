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
> 아래의 예시 형식을 지우고, ```markdown```으로 작성해주세요.

**EX )**
### Member API
1. **회원 생성**
    - **엔드포인트**: `POST /members`
    - **설명**: 새로운 회원을 생성합니다j.
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
    - **응답**: `member_id`를 포함한 Member 객체.
2. **모든 회원 조회**
    - **엔드포인트**: `GET /members`
    - **설명**: 모든 회원 목록을 조회합니다.
    - **응답**: Member 객체 리스트.
3. ... (위와 같은 형식으로 만들어 주시면 됩니다!)

### Member API
1. **회원 생성**
    - **엔드포인트**: `POST /member`
    - **설명**: 새로운 회원을 생성합니다.
    - **요청 본문**:
        ```json
       {
          "email": "string",
          "password": "string",
          "role": "ADMIN",
          "name": "string",
          "age": 0,
          "isAccountExpired": true,
          "isAccountLocked": true
        }
        ```
    - **응답**: `member_id`를 포함한 Member 객체.

2. **회원 전체 조회**
    - **엔드포인트**: `GET /member`
    - **설명**: 모든 회원 목록을 조회합니다.
    - **응답**: MemberDTO 객체 리스트.
      ```json
       [
        {
          "email": "string",
          "role": "ADMIN",
          "name": "string",
          "age": 0,
          "isAccountExpired": true,
          "isAccountLocked": true
        }
      ]
        ```
    
3. **회원 ID로 조회**
    - **엔드포인트**: `GET /member/{id}`
    - **설명**: 특정 회원을 조회합니다.
    - **응답**: MemberDTO 객체
      ```json
       {
          "email": "string",
          "role": "ADMIN",
          "name": "string",
          "age": 0,
          "isAccountExpired": true,
          "isAccountLocked": true
        }
        ```

4. **회원 정보 수정**
    - **엔드포인트**: `PUT /member/{id}`
    - **설명**: 특정 회원 정보를 수정합니다.
    - **요청 본문**:
        ```json
       {
          "email": "string",,
          "role": "ADMIN",
          "name": "string",
          "age": 0,
          "isAccountExpired": true,
          "isAccountLocked": true
        }
        ```
    - **응답**: MemberDTO 객체.
       ```json
         {
            "email": "string",,
            "role": "ADMIN",
            "name": "string",
            "age": 0,
            "isAccountExpired": true,
            "isAccountLocked": true
          }
        ```

5. **회원 ID로 삭제**
   - **엔드포인트**: `DELETE /member/{id}`
    - **설명**: 특정 회원을 삭제합니다.
    - **응답**: 200 ok
   

### Coupon API
1. **쿠폰 생성**
    - **엔드포인트**: `POST /coupon`
    - **설명**: 쿠폰을 생성합니다
    - **요청 본문**:
        ```json
          {
            "type": "PERCENTAGE",
            "discount": 0,
            "issueDate": "2024-05-27T14:47:12.496Z",
            "expirationDate": "2024-05-27T14:47:12.496Z"
          }
        ```
    - **응답**: `coupon_id`를 포함한 Coupon 객체.

2. **모든 쿠폰 조회**
    - **엔드포인트**: `GET /coupon`
    - **설명**: 모든 쿠폰을 조회합니다
    - **응답**: CouponDTO 리스트 객체
      ```json
          [
            {
              "id": 0,
              "type": "PERCENTAGE",
              "discount": 0,
              "issueDate": "2024-05-27T14:49:27.399Z",
              "expirationDate": "2024-05-27T14:49:27.399Z"
            }
          ]
        ```
3. **쿠폰 정보 수정**
    - **엔드포인트**: `PUT /coupon/{id}`
    - **설명**: 특정 쿠폰 정보를 수정합니다.
    - **요청 본문**:
        ```json
        {
          "id": 0,
          "type": "PERCENTAGE",
          "discount": 0,
          "issueDate": "2024-05-27T14:51:07.053Z",
          "expirationDate": "2024-05-27T14:51:07.053Z"
        }
        ```
    - **응답**:Coupon 객체.

4. **쿠폰 삭제**
    - **엔드포인트**: `DELETE /coupon/{id}`
    - **설명**: 특정 쿠폰을 삭제합니다.
    - **응답**: 200 ok

### Coupon Holders API
1. **특정 회원에게 쿠폰 할당**

2. **모든 쿠폰 보유자 조회**
    - **엔드포인트**: `GET /coupon-holders`
    - **설명**: 모든 쿠폰 보유자를 조회합니다
    - **응답**: MemberDTO 리스트를 반환합니다.
      ```json
        [
          {
            "email": "string",
            "role": "ADMIN",
            "name": "string",
            "age": 0,
            "isAccountExpired": true,
            "isAccountLocked": true
          }
        ]
        ```
3. **회원ID로 해당 회원이 보유하고 있는 쿠폰 조회**
    - **엔드포인트**: `PUT /coupon-holders/member/{memberId}`
    - **설명**: 특정 회원이 보유하고있는 쿠폰을 조회합니다.
    - **응답**: Coupon 객체 리스트

4. **쿠폰ID로 해당 쿠폰을 보유하고 있는 회원 조회**
    - **엔드포인트**: `PUT /coupon-holders/coupon/{couponId}`
    - **설명**: 특정 쿠폰을 보유하고있는 회원들을 조회합니다.
    - **응답**: MemberDTO 객체 리스트.
       ```json
        [
          {
            "email": "string",
            "role": "ADMIN",
            "name": "string",
            "age": 0,
            "isAccountExpired": true,
            "isAccountLocked": true
          }
        ]
        ```
5. **특정 회원의 쿠폰 삭제**
    - **엔드포인트**: `DELETE /coupon-holders/delete?memberId = 1 & couponId = 1`
    - **설명**: 특정회원의 특정 쿠폰을 삭제합니다.
    - **응답**: 200 ok

---
### 5. 노션에 본인 브랜치 URL 제출
✅ [본인 브랜치 URL 제출 링크](https://www.notion.so/CRUD-f59053587cd74f4ab5fca7841d5fac83?pvs=4)

### 6. 끝~!
<img width="250" alt="Untitled" src="https://cdn.sketchpan.com/member/e/exosm12/draw/1454491678758/0.png">
