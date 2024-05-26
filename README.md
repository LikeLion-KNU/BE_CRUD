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
    - **엔드포인트**: `POST /member/create`
    - **설명**: 새로운 회원을 생성합니다.
    - **요청 본문**:
    ```json
     {
     "email":"123123@naver.com",
     "password":"999",
     "name":"hello world",
     "age":"24"
     }
  - **응답**: 상태코드) 201 CREATED, `name, role`
    ```json
    {
    "name": "hello world",
    "role": "USER"
    }
2. **모든 회원 조회**
    - **엔드포인트**: `GET /member/users`
    - **설명**: 모든 회원 목록을 조회합니다.
    - **응답**: 상태코드) 200 OK, Member 객체 리스트.
    ```json
   [
     {
       "age": 24,
       "name": "hello world"
     },
     {
       "age": 23,
       "name": "hello world!"
     }
   ]
3. **회원 ID로 조회**
    - **엔드포인트**: `GET /member/user/{memberId}`
    - **설명**: 회원 ID로 회원을 조회합니다.
    - **응답**: 상태코드) 200 OK, 회원 ID에 해당하는 간단 회원 객체
   ```JSON
    {
    "age": 24,
    "name": "hello word"
    }
4. **회원 정보 수정**
   - **엔트포인트**: `POST /member/update`
   - **설명**: 회원 정보를 수정합니다. (age, name, email)
   - **요청 본문**
     ```json
     {
      "memberId":"1",
      "email":"qwe@gmail.com",
      "password":"pw123",
      "name":"name123"
     }
   - **응답** : 상태코드) 200 OK
     ```json
     {
      "memberId": 1,
      "email": "qwe@gmail.com",
      "password": "pw123",
      "name": "name123"
     }
5. **회원 정보 삭제**
   - **엔트포인트**: `POST /member/delete/{memberId}`
   - **설명**: 회원 정보를 삭제합니다.
   - **응답**: 상태코드) 204 NO_CONTENT

### Coupon API
1. **쿠폰 생성**
   - **엔트포인트**: `POST /coupon/create`
   - **설명**: 쿠폰을 생성합니다.
   - **요청 본문**
   ```json
     {
       "couponType" : "PERCENTAGE",
       "discount" : "10",
       "expiration" : "3"
     }
  - **응답** (상태 코드: 201 CREATED)
     ```json
     {
     "couponId": 1,
     "couponType": "PERCENTAGE",
     "issueDate": "2024-05-26T19:46:30.8716693",
     "expirationDate": "2024-08-26T19:46:30.8716693"
     }
2. **모든 쿠폰 조회**
   - **엔트포인트**: `GET /coupon/create`
   - **설명**: 모든 쿠폰 정보를 조회합니다.
   - **응답**: (상태코드 : 200 OK)
   ```json
     [
      {
       "couponId": 1,
       "couponType": "FIXED_AMOUNT",
       "discount": 1000,
       "issueDate": "2024-05-26T19:57:23.334448",
       "expirationDate": "2024-11-26T19:57:23.334448"
      },
      {
       "couponId": 2,
       "couponType": "PERCENTAGE",
       "discount": 10,
       "issueDate": "2024-05-26T19:57:33.883598",
       "expirationDate": "2024-08-26T19:57:33.883598"
      }
     ]
3. **쿠폰 정보 수정**
   - **엔트포인트**: `POST /coupon/update`
   - **설명**: 쿠폰 정보를 수정합니다. (couponType, discount)
   - **요청 본문**
   - ```json
     {
     "couponId" : "1",
     "couponType" : "PERCENTAGE",
     "discount" : "15"
     }
   - **응답** (상태 코드: 200 OK)
   - ```json
     {
     "couponType": "PERCENTAGE",
     "discount": 15
     }
4. **쿠폰 삭제**
   - **엔트포인트**: `POST /coupon/delete/{couponId}`
   - **설명**: 쿠폰 정보를 삭제합니다.
   - **응답** (상태 코드: 204 NO CONTENT, BODY : NULL)
### CouponHolder API
1. **특정 회원에게 쿠폰 할당**
   - **엔트포인트**: `POST coupon/allocate?memberId={memberId}&couponId={couponId}`
   - **설명**: 특정 쿠폰(couponId)를 특정 회원(memberId)에게 할당합니다.
   - **응답** (상태 코드: 201 CREATED, BODY : NULL)
2. **모든 쿠폰 보유자 조회**
   - **엔트포인트**: `GET coupon/couponHolders`
   - **설명**: 모든 쿠폰 보유자를 조회합니다.
   - **응답** (상태 코드: 200 OK)
   ```json
   [
    {
        "memberId": 1,
        "name": "hello world",
        "discount": 10,
        "issueDate": "2024-05-26T20:18:56.295948",
        "expirationDate": "2024-08-26T20:18:56.295948"
    },
    {
        "memberId": 1,
        "name": "hello world",
        "discount": 10,
        "issueDate": "2024-05-26T20:18:56.295948",
        "expirationDate": "2024-08-26T20:18:56.295948"
    }
   ]
3. **회원ID로 해당 회원이 보유하고 있는 쿠폰 조회**
   - **엔트포인트**: `GET coupon/couponHolders`
   - **설명**: 모든 쿠폰 보유자를 조회합니다.
   - **응답** (상태 코드: 200 OK)
4. **쿠폰ID로 해당 쿠폰을 보유하고 있는 회원 조회**
   - **엔트포인트**: `GET coupon/couponHolders/{couponId}`
   - **설명**: 특정 쿠폰(couponId)을 지닌 모든 회원을 조회합니다.
   - **응답** (상태 코드: 200 OK)
   ```json
   [
    {
        "age": 24,
        "name": "hello world123"
    },
    {
        "age": 23,
        "name": "hello world321"
    }
   ]
5. **특정 회원의 쿠폰 삭제**
   - **엔트포인트**: `GET coupon/couponHolder/delete/{memberId}`
   - **설명**: 특정 회원(memberId)의 모든 쿠폰을 삭제합니다.
   - **응답** (상태 코드: 204 NO_CONTENT, BODY : NULL)
---
### 5. 노션에 본인 브랜치 URL 제출
✅ [본인 브랜치 URL 제출 링크](https://www.notion.so/CRUD-f59053587cd74f4ab5fca7841d5fac83?pvs=4)

### 6. 끝~!
<img width="250" alt="Untitled" src="https://cdn.sketchpan.com/member/e/exosm12/draw/1454491678758/0.png">
