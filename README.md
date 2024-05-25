# 🦁 12th LIKELION CRUD Assignment


### Member API

1. **회원 생성**
   - **엔드포인트**: `POST /api/members`
     - **설명**: 새로운 회원을 생성합니다.
     - **요청 본문**:
         ```json
         {
           "email": "string",
           "password": "string",
           "role": "ADMIN 또는 USER",
           "name": "string",
           "age": "number"
         }
         ```
     - **응답**: 새로 생성된 Member 객체.

2. **회원 전체 조회**
   - **엔드포인트**: `GET /api/members`
   - **설명**: 모든 회원 목록을 조회합니다.
   - **요청 본문**: 없음.
   - **응답**: Member 객체 리스트.

3. **회원 ID로 조회**
   - **엔드포인트**: `GET /api/members/{id}`
   - **설명**: 특정 ID를 가진 회원을 조회합니다.
   - **요청 본문**: 없음.
   - **응답**: Member 객체.

4. **회원 정보 수정**
   - **엔드포인트**: `PUT /api/members`
   - **설명**: 기존 회원의 정보를 수정합니다.
   - **요청 본문**:
       ```json
       {
         "memberId": "string",
         "email": "string",
         "password": "string",
         "role": "ADMIN, USER",
         "name": "string",
         "age": "number",
         "isAccountExpired": "boolean",
         "isAccountLocked": "boolean"
       }
       ```
   - **응답**: 수정된 Member 객체.

5. **회원 ID로 삭제**
   - **엔드포인트**: `DELETE /api/members/{id}`
   - **설명**: 특정 회원을 삭제합니다.
   - **요청 본문**: 없음.
   - **응답**: 없음.


### Coupon API

1. **쿠폰 생성**
   - **엔드포인트**: `POST /api/coupons`
   - **설명**: 새로운 쿠폰을 생성합니다.
   - **요청 본문**:
       ```json
       {
         "type": "PERCENTAGE, FIXED_AMOUNT",
         "discount": "number",
         "expirationDate": "yyyy-MM-dd'T'HH:mm:ss"
       }
       ```
   - **응답**: 새로 생성된 Coupon 객체.

2. **모든 쿠폰 조회**
   - **엔드포인트**: `GET /api/coupons`
   - **설명**: 모든 회원 목록을 조회합니다.
   - **요청 본문**: 없음.
   - **응답**: Member 객체 리스트.

3. **쿠폰 정보 수정**
   - **엔드포인트**: `PUT /api/coupons`
   - **설명**: 특정 ID를 가진 쿠폰을 수정합니다.
   - **요청 본문**:
       ```json
       {
         "couponId": "string",
         "type": "PERCENTAGE, FIXED_AMOUNT",
         "discount": "number",
         "issueDate": "yyyy-MM-dd'T'HH:mm:ss",
         "expirationDate": "yyyy-MM-dd'T'HH:mm:ss"
       }
       ```
   - **응답**: 수정된 Coupon 객체.

4. **쿠폰 삭제**
   - **엔드포인트**: `DELETE /api/coupons/{id}`
   - **설명**: 기존 쿠폰을 삭제합니다.
   - **요청 본문**: 없음.
   - **응답**: 없음.


### 쿠폰 보유 목록

1. **특정 회원에게 쿠폰 할당**
   - **엔드포인트**: `POST /api/coupons/holders`
   - **설명**: 특정 회원에게 쿠폰을 할당합니다.
   - **요청 파라미터**:
       ``` text
         memberId: 할당할 회원의 ID
         couponId: 할당할 쿠폰의 ID
       ```
   - **응답**: CouponHolder 객체.

2. **모든 쿠폰 보유자 조회**
   - **엔드포인트**: `GET /api/coupons/holders`
   - **설명**: 쿠폰이 할당된 회원과 쿠폰 객체를 조회합니다.
   - **요청 본문**: 없음.
   - **응답**: CouponHolder 객체 리스트.

3. **회원 ID로 해당 회원이 보유하고 있는 쿠폰 조회**
   - **엔드포인트**: `GET /api/coupons/holders/member/{id}`
   - **설명**: 특정 회원이 보유하고 있는 쿠폰 목록을 조회합니다.
   - **요청 파라미터**: 없음.
   - **응답**: Coupon 객체 리스트.

4. **쿠폰 ID로 해당 쿠폰을 보유하고 있는 회원 조회**
   - **엔드포인트**: `GET /api/coupons/holders/coupon/{id}`
   - **설명**: 특정 쿠폰을 보유하고 있는 회원 목록을 조회합니다.
   - **요청 본문**: 없음.
   - **응답**: Member 객체 리스트.

5. **특정 회원의 쿠폰 삭제**
   - **엔드포인트**: `DELETE /api/coupons/holders`
   - **설명**: 특정 회원이 보유하고 있는 쿠폰 목록에서 특정 쿠폰을 제거합니다.
   - **요청 파라미터**:
       ``` text
         memberId: 제거할 회원의 ID
         couponId: 제거할 쿠폰의 ID
       ```
   - **응답**: 없음.
