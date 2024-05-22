# 🦁 12th LIKELION CRUD Assignment

#### **LEESEUNGBIN BE  0520 Assignment**

### Member API
1. **회원 생성**
    - **엔드포인트**: `POST -> /member/create`
    - **설명**: `회원 생성`
    - **요청 본문**:
        ```json
        {
          "name": "string",
          "password": "string",
          "age": "int",
          "email": "string",
        }
        ```
    - **응답**: `Long memberId 반환`
2. **회원 전체 조희**
    - **엔드포인트**: `GET /member/all`
    - **설명**: `모든 회원을 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `MemberReadResponse 객체 리스트 반환`
3. **회원ID를 이용하여 조희**
    - **엔드포인트**: `GET /member/find/{memberId}`
    - **설명**: `회원의 ID를 이용하여 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `MemberReadResponse 객체 반환`
3. **회원 정보 수정**
    - **엔드포인트**: `PUT /member/update/{memberId}`
    - **설명**: `회원의 ID를 이용하여 수정`
    - **요청 본문**:
        ```json
	    {
          "name": "string",
          "age": "int"
        }
        ```
    - **응답**: `updatedMemberEmail 반환`
4. **회원 ID를 이용하여 삭제**
    - **엔드포인트**: `DELETE /member/delete/{memberId}`
    - **설명**: `회원의 ID를 이용하여 삭제`
    - **요청 본문**:
        ```json
	    NONE
        ```
    - **응답**: `Long memberId 반환`
### COUPON API
1. **쿠폰 생성**
    - **엔드포인트**: `POST -> /coupon/create`
    - **설명**: `쿠폰 생성`
    - **요청 본문**:
        ```json
        {
          "Type": "PERCENTAGE, FIXED", 
          "discount": "int",
          "expirationDate": "yyyy-MM-dd'T'HH:mm:ss",
          "issueDate" : "yyyy-MM-dd'T'HH:mm:ss"
        }
        ```
    - **응답**: `Long couponId 반환`
2. **쿠폰 조회**
    - **엔드포인트**: `GET -> /coupon/all`
    - **설명**: `모든 쿠폰을 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `CouponReadResponse 객체 리스트 반환`
3. **쿠폰 정보 수정**
    - **엔드포인트**: `PUT -> /coupon/update/{couponId}`
    - **설명**: `쿠폰의 ID를 사용하여 수정`
    - **요청 본문**:
        ```json
        {
          "Type": "PERCENTAGE, FIXED", 
          "discount": "int",
          "expirationDate": "yyyy-MM-dd'T'HH:mm:ss",
          "issueDate" : "yyyy-MM-dd'T'HH:mm:ss"
        }
        ```
    - **응답**: `Long couponId 반환`
4. **쿠폰 삭제**
    - **엔드포인트**: `DELETE -> /coupon/delete/{memberId}`
    - **설명**: `쿠폰의 ID를 사용하여 삭제`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `Long couponId 반환`
### COUPON HOLDERS API
1. **모든 쿠폰 보유자 조회**
    - **엔드포인트**: `GET -> /coupon-holder/members-with-all-coupons`
    - **설명**: `모든 쿠폰 보유자 조회`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `MemberWithAllCouponsResponse 객체 리스트 반환`
2. **특정 회원에게 쿠폰 할당**
    - **엔드포인트**: `POST -> /coupon-holder/assign`
    - **설명**: `회원과 쿠폰의 ID값 2개를 리퀘스트 바디로 받아서 조회 후 할당`
    - **요청 본문**:
        ```json
        {
          "memberId" : "Long",
          "couponId" : "Long"

        }
        ```
    - **응답**: `couponHolderId 객체 반환`
3. **회원ID로 해당 회원이 보유하고 있는 쿠폰 조회**
    - **엔드포인트**: `GET -> /coupon-holder/member-coupon/{memberId}`
    - **설명**: `회원의 ID를 사용하여 보유한 쿠폰을 반환`
    - **요청 본문**:
        ```json
        NONE    
        ```
    - **응답**: `findMemberRespons 객체 리스트 반환`
4. **쿠폰ID로 해당 회원이 보유하고 있는 쿠폰 조회**
    - **엔드포인트**: `GET -> /coupon-holder/member-coupon/{couponId}`
    - **설명**: `쿠폰의 ID를 사용하여 보유한 쿠폰을 반환`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `findCouponByMemberIds 객체 리스트 반환`
4. **특정 회원의 쿠폰 삭제**
    - **엔드포인트**: `DELETE -> /delete/{memberId}/{couponId}`
    - **설명**: `회원과 쿠폰의 ID값 2개를 쿼리 파라미터로 받아서 조회 후 삭제`
    - **요청 본문**:
        ```json
        NONE
        ```
    - **응답**: `삭제 완료 메세지 응답`
