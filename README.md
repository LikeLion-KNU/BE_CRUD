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


---

### CouponHolder API
