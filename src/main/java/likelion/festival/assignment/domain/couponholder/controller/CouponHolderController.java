package likelion.festival.assignment.domain.couponholder.controller;

import jakarta.websocket.server.PathParam;
import likelion.festival.assignment.domain.couponholder.dto.request.CouponToMemberRequest;
import likelion.festival.assignment.domain.couponholder.dto.response.FindAllMemberWithCouponResponse;
import likelion.festival.assignment.domain.couponholder.dto.response.FindCouponWithMemberResponse;
import likelion.festival.assignment.domain.couponholder.dto.response.FindMemberWithCouponResponse;
import likelion.festival.assignment.domain.couponholder.service.CouponHolderService;
import likelion.festival.assignment.global.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.annotation.Repeatable;
import java.util.List;
@RestController
@RequestMapping("/couponholder")
public class CouponHolderController {

    CouponHolderService couponHolderService;

    @Autowired
    public CouponHolderController(CouponHolderService couponHolderService) {
        this.couponHolderService = couponHolderService;
    }

    /**특정 회원에게 쿠폰 할당**/
    @PostMapping("/coupontomember")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> couponToMember(
            @RequestBody()CouponToMemberRequest couponToMemberRequest
            ){

        Long saveId = couponHolderService.couponToMember(couponToMemberRequest);
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED,saveId));
    }

    /**모든 쿠폰 보유자 조회**/
    @GetMapping("/all")
    public ResponseEntity<ApiUtil.ApiSuccessResult<List<FindAllMemberWithCouponResponse>>> getAllCouponHolder(){

        List<FindAllMemberWithCouponResponse> responseList = couponHolderService.getAllCouponHolder();
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK,responseList));
    }

   /** 회원ID로 해당 회원이 보유하고 있는 쿠폰 조회**/
   @GetMapping("/couponswithmember/{memberId}")
    public ResponseEntity<ApiUtil.ApiSuccessResult<List<FindCouponWithMemberResponse>>> getCouponsWithMember(
            @PathVariable("memberId")Long memberId
   ){
       List<FindCouponWithMemberResponse> responseList = couponHolderService.getCouponWithMember(memberId);
       return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK,responseList));
   }

   /** 쿠폰ID로 해당 쿠폰을 보유하고 있는 회원 조회**/

   @GetMapping("/memberswithcoupon/{couponId}")
    public ResponseEntity<ApiUtil.ApiSuccessResult<List<FindMemberWithCouponResponse>>>getMembersWithCoupon(
            @PathVariable("couponId") Long couponId
   ){
       List<FindMemberWithCouponResponse> responseList = couponHolderService.getMemberWithCoupon(couponId);
       return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK, responseList));
   }

   /** 특정 회원의 쿠폰 삭제**/
   @DeleteMapping("/delete")
    public ResponseEntity<ApiUtil.ApiSuccessResult<?>>deleteByCouponAndMember(
            @RequestParam("memberId")Long memberId,
            @RequestParam("couponId")Long couponId
   ) throws IOException {
       couponHolderService.deleteCouponWithMember(memberId, couponId);
       return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK));
   }
}
