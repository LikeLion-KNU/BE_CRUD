# 🦁 12th LIKELION CRUD Assignment

#### **LEESEUNGBIN BE  0520 Assignment**

### Member API
1. **회원 생성**
    - **엔드포인트**: `POST -> /api/members`
    - **설명**: `회원 생성`
    - **요청 본문**:
        ```json
        {
          "name": "string", not null
          "password": "string", not null
          "age": "int",
          "role": "ADMIN, USER",
          "email": "string",
          "isAccountExpired": "boolean",
          "isAccountLocked": "boolean"
        }
        ```
    - **응답**: `Long member_id 반환`
2. **회원 전체 조희**
    - **엔드포인트**: `GET /api/members`
    - **설명**: `모든 회원을 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `MemberResponseDto 객체 리스트 반환`
3. **회원ID를 이용하여 조희**
    - **엔드포인트**: `GET /api/members/{id}`
    - **설명**: `회원의 ID를 이용하여 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `MemberResponseDto 객체 반환`
3. **회원 정보 수정**
    - **엔드포인트**: `PUT /api/members/{id}`
    - **설명**: `회원의 ID를 이용하여 수정`
    - **요청 본문**:
        ```json
	    {
          "name": "string", not null
          "age": "int",
          "role": "ADMIN, USER", not null
          "email": "string" not null
        }
        ```
    - **응답**: `Long member_id 반환`
4. **회원 ID를 이용하여 삭제**
    - **엔드포인트**: `DELETE /api/members/{id}`
    - **설명**: `회원의 ID를 이용하여 삭제`
    - **요청 본문**:
        ```json
	    NONE
        ```
    - **응답**: `반환값 없음`
### COUPON API
1. **쿠폰 생성**
    - **엔드포인트**: `POST -> /api/coupons`
    - **설명**: `쿠폰 생성`
    - **요청 본문**:
        ```json
        {
          "Type": "PERCENTAGE, FIXED", not null
          "discount": "int",
          "expirationDate": "yyyy-MM-dd'T'HH:mm:ss" not null
        }
        ```
    - **응답**: `Long coupon_id 반환`
2. **쿠폰 조회**
    - **엔드포인트**: `GET -> /api/coupons`
    - **설명**: `모든 쿠폰을 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `CouponResponseDto 객체 리스트 반환`
3. **쿠폰 정보 수정**
    - **엔드포인트**: `PUT -> /api/coupons/{id}`
    - **설명**: `쿠폰의 ID를 사용하여 수정`
    - **요청 본문**:
        ```json
        {
          "Type": "PERCENTAGE, FIXED", not null
          "discount": "int",
          "expirationDate": "yyyy-MM-dd'T'HH:mm:ss" not null
        }
        ```
    - **응답**: `CouponResponseDto 객체 리스트 반환`
4. **쿠폰 삭제**
    - **엔드포인트**: `DELETE -> /api/coupons/{id}`
    - **설명**: `쿠폰의 ID를 사용하여 삭제`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `반환값 없음`
### COUPON HOLDERS API
1. **모든 쿠폰 보유자 조회**
    - **엔드포인트**: `GET -> /api/memberCoupon`
    - **설명**: `모든 쿠폰 보유자 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `CouponHoldersResponseDto 객체 리스트 반환`
2. **특정 회원에게 쿠폰 할당**
    - **엔드포인트**: `POST -> /api/memberCoupon?memberId=1&couponId=1`
    - **설명**: `회원과 쿠폰의 ID값 2개를 쿼리 파라미터로 받아서 조회 후 할당`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `CouponHoldersResponseDto 객체 반환`
3. **회원ID로 해당 회원이 보유하고 있는 쿠폰 조회**
    - **엔드포인트**: `GET -> /api/memberCoupon/member/{id}`
    - **설명**: `회원의 ID를 사용하여 보유한 쿠폰을 반환`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `CouponHoldersResponseDto 객체 리스트 반환`
4. **쿠폰ID로 해당 회원이 보유하고 있는 쿠폰 조회**
    - **엔드포인트**: `GET -> /api/memberCoupon/coupon/{id}`
    - **설명**: `쿠폰의 ID를 사용하여 보유한 쿠폰을 반환`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `CouponHoldersResponseDto 객체 리스트 반환`
4. **특정 회원의 쿠폰 삭제**
    - **엔드포인트**: `DELETE -> /api/memberCoupon?memberId=1&couponId=1`
    - **설명**: `회원과 쿠폰의 ID값 2개를 쿼리 파라미터로 받아서 조회 후 삭제`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `반환값 없음`
