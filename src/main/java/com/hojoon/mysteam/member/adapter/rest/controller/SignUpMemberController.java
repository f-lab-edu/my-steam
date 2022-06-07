package com.hojoon.mysteam.member.adapter.rest.controller;

import com.hojoon.mysteam.member.adapter.rest.dto.request.SignUpMemberRequest;
import com.hojoon.mysteam.member.adapter.rest.dto.response.SignUpMemberResponse;
import com.hojoon.mysteam.member.application.usecase.CreateMemberPort;
import com.hojoon.mysteam.member.domain.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SignUpMemberController {

  private final CreateMemberPort createMemberUseCase;

  @PostMapping("/signup")
  public ResponseEntity<SignUpMemberResponse> signUp(
      @RequestBody SignUpMemberRequest signUpMemberRequest) {
    Member member = createMemberUseCase.apply(signUpMemberRequest.toCommand());
    return ResponseEntity.ok().body(new SignUpMemberResponse(member.getEmail()));
  }
}
