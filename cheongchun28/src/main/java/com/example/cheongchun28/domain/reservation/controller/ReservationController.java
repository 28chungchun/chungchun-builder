package com.example.cheongchun28.domain.reservation.controller;


import com.example.cheongchun28.domain.reservation.dto.ReservationRequestDto;
import com.example.cheongchun28.domain.reservation.dto.ReservationResponseDto;
import com.example.cheongchun28.domain.reservation.service.ReservationService;
import com.example.cheongchun28.domain.user.entity.User;
import com.example.cheongchun28.global.common.dto.CustomResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;


    // 예약 등록
    @PostMapping()
    public ResponseEntity<CustomResponseDto> createReservation(@AuthenticationPrincipal User auth,
                                                               @RequestBody ReservationRequestDto.CreateReservationDto createReservationDto) {
        log.info("reservation create, className: {}, auth: {}", createReservationDto.getClassName(), auth.getUsername());
        return ResponseEntity.ok(reservationService.createReservation(auth, createReservationDto));
    }

    @GetMapping()
    //조회하기(Read/Get) - (전체)
    public ResponseEntity<ReservationResponseDto.ReservationGetResponseDto> getedReservation(@AuthenticationPrincipal User auth) {
        log.info("reservation read, auth: {}", auth.getUsername());
        return ResponseEntity.ok(reservationService.getReservation(auth));
    }

    // 예약 삭제
    @DeleteMapping("/{reservationCode}")
    public ResponseEntity<CustomResponseDto> deleteReservation(@AuthenticationPrincipal User auth,
                                                               @PathVariable("reservationCode") String code) {
        log.info("reservation delete, auth: {}, reservationCode: {}", auth.getUsername(), code);
        return ResponseEntity.ok(reservationService.deleteReservation(auth, code));
    }

}
    @GetMapping("/{reservationCode}")
    //예약 건당 조회하기(Read/Get) - (하나에 대한)
    public ReservationResponseDto.ReservationGetOneResponseDto getedReservation(@PathVariable("reservationCode") String code) {
        log.info("reservation get, reservationCode: {}", code);
        return reservationService.getReservation(code);
    }
}

