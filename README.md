### Member API
1. **회원 생성**
   - **엔드포인트**: `POST /member`
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
   - **엔드포인트**: `GET /member`
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
   - **엔드포인트**: `GET /member/{memberId}`
   - **설명**: 회원 ID로 회원을 조회합니다.
   - **응답**: 상태코드) 200 OK, 회원 ID에 해당하는 간단 회원 객체
   ```JSON
    {
    "age": 24,
    "name": "hello word"
    }
4. **회원 정보 수정**
   - **엔트포인트**: `PATCH /member/{memberId}`
   - **설명**: 회원 정보를 수정합니다. (age, name, email)
   - **요청 본문**
     ```json
     {
      "email":"qwe@gmail.com",
      "password":"pw123",
      "name":"name123"
     }
   - **응답** : 상태코드) 200 OK
     ```json
     {
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
   - **엔트포인트**: `POST /coupon`
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
   - **엔트포인트**: `GET /coupon`
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
   - **엔트포인트**: `PATCH /coupon/{couponId}`
   - **설명**: 쿠폰 정보를 수정합니다. (couponType, discount)
   - **요청 본문**
   - ```json
     {
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
   - **엔트포인트**: `DELETE /coupon/{couponId}`
   - **설명**: 쿠폰 정보를 삭제합니다.
   - **응답** (상태 코드: 204 NO CONTENT, BODY : NULL)
### CouponHolder API
1. **특정 회원에게 쿠폰 할당**
   - **엔트포인트**: `POST /member/{memberId}/coupon`
   - **설명**: 특정 쿠폰(couponId)를 특정 회원(memberId)에게 할당합니다.
   - - **요청 본문**
   - ```json
     {
     "couponId" : "1",
     }
   - **응답** (상태 코드: 201 CREATED, BODY : NULL)
2. **모든 쿠폰 보유자 조회**
   - **엔트포인트**: `GET /member?hasCoupon=true`
   - **설명**: 모든 쿠폰 보유자를 조회합니다.
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
3. **회원ID로 해당 회원이 보유하고 있는 쿠폰 조회**
   - **엔트포인트**: `GET /member/{memberId}/coupon`
   - **설명**: 모든 쿠폰 보유자를 조회합니다.
   - **응답** (상태 코드: 200 OK)
4. **쿠폰ID로 해당 쿠폰을 보유하고 있는 회원 조회**
   - **엔트포인트**: `GET /member?has-coupon=true&coupon-id={couponId}`
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
   - **엔트포인트**: `DELETE /member/{memberId}/coupon`
   - **설명**: 특정 회원(memberId)의 모든 쿠폰을 삭제합니다.
   - **응답** (상태 코드: 204 NO_CONTENT, BODY : NULL)