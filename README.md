# 🦁 12th LIKELION CRUD Assignment
### Member API
1. **회원 생성**
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
    - **응답**: `member_id`를 포함한 Member 객체.
2. **모든 회원 조회**
    - **엔드포인트**: `GET /members`
    - **설명**: 모든 회원 목록을 조회합니다.
    - **응답**: Member 객체 리스트.
3. **회원 id로 조회**
   - **엔드포인트**: `GET /member`
   - **설명**: id로 회원을 조회힙니다.
   - **요청 쿼리**:
     - id: 회원 아이디
   - **응답**: Member 객체
4. **회원 정보 수정**
    - **엔드포인트**: `PUT /member`
    - **설명**: 특정 회원의 정보를 수정합니다
    - **요청 쿼리**:
        - id: 회원 아이디
    - **요청 본문(각 항목 생략가능)**:
      ```json
      {
        "email": "string",
        "password": "string",
        "name": "string",
        "age": "number"
      }
      ```
    - **응답**: 수정된 Member 객체
5. **회원 id로 삭제**
    - **엔드포인트**: `DELETE /member`
    - **설명**: id로 회원을 삭제힙니다.
    - **요청 쿼리**:
        - id: 회원 아이디
    - **응답**: 삭제 후 전체 Member 객체 리스트
---


### Coupon API
1. **쿠폰 생성**
    - **엔드포인트**: `POST /coupons`
    - **설명**: 새로운 쿠폰을 생성합니다.
    - **요청 본문**:
        ```json
        {
      "type": "PERCENTAGE 또는 FIXED_AMOUNT",
      "discount": "number",
      "issue_date": "DateTime",
      "expiration_date": "DateTime"
      }
        ```
    - **응답**: `coupon_id`를 포함한 Coupon 객체.
2. **모든 쿠폰 조회**
   - **엔드포인트**: `GET /coupons`
   - **설명**: 모든 쿠폰 목록을 조회합니다.
   - **응답**: Coupon 객체 리스트.
3. **쿠폰 정보 수정**
   - **엔드포인트**: `PUT /coupon`
   - **설명**: 특정 쿠폰의 정보를 수정합니다
   - **요청 쿼리**:
      - id: 쿠폰 아이디
   - **요청 본문(각 항목 생략가능)**:
     ```json
     {
      "type": "PERCENTAGE 또는 FIXED_AMOUNT",
      "discount": "number",
      "issue_date": "DateTime",
      "expiration_date": "DateTime"
     }
     ```
   - **응답**: 수정된 Coupon 객체
4. **쿠폰 id로 삭제**
   - **엔드포인트**: `DELETE /coupon`
   - **설명**: id로 쿠폰을 삭제힙니다.
   - **요청 쿼리**:
      - id: 쿠폰 아이디
   - **응답**: 삭제 후 전체 Coupon 객체 리스트
---

### CouponHolder API
1. **특정 회원에게 쿠폰 할당**
   - **엔드포인트**: `POST /couponHolders`
   - **설명**: 특정 회원에게 특정 쿠폰을 할당합니다
   - **요청 쿼리**:
      - member_id: 회원 아이디
      - coupon_id: 쿠폰 아이디
   - **응답**: 생성된 CouponHolders 객체.
2. **모든 쿠폰 보유자 조회**
   - **엔드포인트**: `GET /couponHolders`
   - **설명**: 모든 CouponHolder를 조회합니다.
   - **응답**: CouponHolders 객체 리스트.
3. **회원 id로 해당 회원이 보유한 쿠폰 조회**
   - **엔드포인트**: `GET /couponsFromMember`
   - **설명**: 특정 회원이 보유한 쿠폰을 모두 조회힙니다.
   - **요청 쿼리**:
      - id: 회원 아이디
   - **응답**: Coupon 객체 리스트
4. **쿠폰 id로 해당 쿠폰을 보유한 회원 조회**
   - **엔드포인트**: `GET /membersFromCoupon`
   - **설명**: 특정 쿠폰을 보유한 회원을 모두 조회힙니다.
   - **요청 쿼리**:
      - id: 쿠폰 아이디
   - **응답**: Member 객체 리스트
5. **특정 회원의 쿠폰 삭제**
   - **엔드포인트**: `DELETE /couponHolders`
   - **설명**: 회원 id와 쿠폰 id를 통해 해당 회원의 쿠폰을 삭제합니다.
   - **요청 쿼리**:
      - member_id: 회원 아이디
      - coupon_id: 쿠폰 아이디
   - **응답**: 삭제 후 CouponHolders 객체 리스트
---
