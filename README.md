# 🦁 12th LIKELION CRUD Assignment

### Member API
1. **회원 생성**
    - **엔드포인트**: `POST -> /members`
    - **설명**: `회원 생성`
    - **요청 본문**:
        ```json
        {
          "name": "string", not null
          "password": "string", not null
          "age": "int",
          "email": "string"
        }
        ```
    - **응답**: `MemberRegisterResponseDTO 객체 반환`
2. **회원 전체 조희**
    - **엔드포인트**: `GET -> /members`
    - **설명**: `모든 회원을 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `Member 객체 리스트 반환`
3. **회원ID를 이용하여 조희**
    - **엔드포인트**: `GET -> /members/{id}`
    - **설명**: `회원의 ID를 이용하여 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `Member 객체 반환`
4. **회원 정보 수정**
    - **엔드포인트**: `PUT -> /amembers/{id}`
    - **설명**: `회원의 ID를 이용하여 수정`
    - **요청 본문**:
        ```json
	    {
          "name": "string", not null
          "age": "int",
          "password": "string", not null
          "email": "string", not null
        }
        ```
    - **응답**: `MemberUpdateResponseDTO 객체 반환`
4. **회원 ID를 이용하여 삭제**
    - **엔드포인트**: `DELETE /members/{id}`
    - **설명**: `회원의 ID를 이용하여 삭제`
    - **요청 본문**:
        ```json
	    NONE
        ```
    - **응답**: `반환값 없음`
### COUPON API
1. **쿠폰 생성**
    - **엔드포인트**: `POST -> /coupons`
    - **설명**: `쿠폰 생성`
    - **요청 본문**:
        ```json
        {
          "Type": "PERCENTAGE, FIXED", not null
          "discount": "int",
          "expirationDate": "yyyy-MM-dd'T'HH:mm:ss" not null
        }
        ```
    - **응답**: `CouponRegisterResponseDTO 객체 반환`
2. **쿠폰 조회**
    - **엔드포인트**: `GET -> /coupons`
    - **설명**: `모든 쿠폰을 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `Coupon 객체 리스트 반환`
3. **쿠폰 정보 수정**
    - **엔드포인트**: `PUT -> /coupons/{couponId}`
    - **설명**: `쿠폰의 ID를 사용하여 수정`
    - **요청 본문**:
        ```json
        {
          "Type": "PERCENTAGE, FIXED", not null
          "discount": "int",
          "expirationDate": "yyyy-MM-dd'T'HH:mm:ss" not null
        }
        ```
    - **응답**: `CouponUpdateResponseDto 객체 리스트 반환`
4. **쿠폰 삭제**
    - **엔드포인트**: `DELETE -> /coupons/{couponId}`
    - **설명**: `쿠폰의 ID를 사용하여 삭제`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `반환값 없음`
5. **특정 회원에게 쿠폰 할당**
    - **엔드포인트**: `POST -> '/coupons/assign/{memberId}/{couponId}`
    - **설명**: `회원 ID, 쿠폰 ID를 쿼리 파라미터로 받아서 조회 후 할당`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `Long memberCouponID 반환`
6. **회원ID로 해당 회원이 보유하고 있는 쿠폰 조회**
    - **엔드포인트**: `GET -> '/coupons/{memberId}`
    - **설명**: `회원의 ID를 쿼리 파라미터로 받아서 보유한 쿠폰을 반환`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `Coupon 객체 리스트 반환`
7. **특정 회원의 쿠폰 삭제**
    - **엔드포인트**: `DELETE -> '/coupons/{memberId}/{couponId}`
    - **설명**: `회원 ID, 쿠폰 ID를 쿼리 파라미터로 받아서 특정 회원의 특정 쿠폰 삭제`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `반환값 없음`
### COUPON HOLDERS API
1. **모든 쿠폰 보유자 조회**
    - **엔드포인트**: `GET -> /holders`
    - **설명**: `모든 쿠폰 보유자 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `CouponHolders 객체 리스트 반환`
4. **쿠폰 ID로 해당 쿠폰을 보유하고 있는 회원 조회**
    - **엔드포인트**: `GET -> /holders/{couponId}`
    - **설명**: `쿠폰 ID를 쿼리 파라미터로 받아 해당 쿠폰을 보유하고 있는 회원 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `Member 객체 리스트 반환`

