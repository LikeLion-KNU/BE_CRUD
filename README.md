# 🦁 12th LIKELION CRUD Assignment


### Member API
1. **회원 생성**
    - **엔드포인트**: `POST /membersCreate`
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
    - **응답**: MemberRegisterDto.Response
2. **모든 회원 조회**
    - **엔드포인트**: `GET /membersGetAll`
    - **설명**: 모든 회원 목록을 조회합니다.
    - **응답**: Member 객체 리스트.
3. **ID로 회원 조회**
   - **엔드포인트**: `GET /members/get/{id}`
   - **설명**: ID에 따른 회원을 조회합니다.
   - **응답**: Member 객체.
4. **회원 정보 수정**
   - **엔드포인트**: `PUT /members/edit/{id}`
   - **설명**: ID를 사용해 회원 정보 수정.
   - **응답**: MemberUpdateDto.Response
   - 
5. **회원 ID 사용 삭제**
   - **엔드포인트**: `DELETE /members/delete/{id}`
   - **설명**: ID를 사용해 회원 정보 삭제.
   - **응답**: None
---

### Coupon API
1. **쿠폰 생성**
   - **엔드포인트**: `POST /membersCreate`
   - **설명**: 새로운 쿠폰을 생성합니다.
   - **요청 본문**:
       ```json
       {
      "type": "THIRTY",
      "discount": 20,
      "expirationDate": "2999-01-18T11:22:33"
      }
       ```
   - **응답**: CouponRegisterDto.Response
2. **모든 coupon 조회**
   - **엔드포인트**: `GET /coupon/getAll`
   - **설명**: 모든 coupon 목록을 조회합니다.
   - **응답**: List<Coupon>
3. **coupon 정보 수정**
   - **엔드포인트**: `PUT /coupon/edit/{id}`
   - **설명**: ID를 사용해 회원 정보 수정.
   - **응답**: MemberUpdateDto.Response
   -
4. **coupon ID 사용 삭제**
   - **엔드포인트**: `DELETE /coupon/delete/{id}`
   - **설명**: ID를 사용해 coupon 정보 삭제.
   - **응답**: None

---

### CouponHolder API
1. **쿠폰할당**
   - **엔드포인트**: `POST /couponHolder/giveCoupon/{memberId}/{couponId}`
   - **설명**: 특정 회원에게 쿠폰 할당
   - **요청 본문**:
       ```json
       {
 
       }
       ```
   - **응답**: MemberRegisterDto.Response
2. **모든 쿠폰 소유자 조회**
   - **엔드포인트**: `GET /couponHolder/get/All`
   - **설명**: 모든 쿠폰 소유자 목록을 조회합니다.
   - **응답**: couponHolder 객체 리스트.
3. **회원 ID로 쿠폰 조회**
   - **엔드포인트**: `GET /couponHolder/memberID/{memberId}`
   - **설명**: ID에 따른 쿠폰을 조회합니다.
   - **응답**: couponHolder 객체 리스트.
4. **쿠폰 id로 회원 조회**
   - **엔드포인트**: `GET /couponHolder/couponID/{couponId}`
   - **설명**: ID를 사용해 회원 조회합니다.
   - **응답**: couponHolder 객체 리스트.
   -
5. **특정 회원, 쿠폰 삭제**
   - **엔드포인트**: `DELETE /couponHolder/delete/{memberId}/{couponId}`
   - **설명**: 회원 id 쿠폰 id 를 사용한 쿠폰 삭제.
   - **응답**: void