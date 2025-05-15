package com.example.leapit.application;

import com.example.leapit._core.error.ex.ExceptionApi404;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationResponse.ListViewDTO myPageApply(Integer userId) {
        if (userId == null) throw new ExceptionApi404("회원정보가 존재하지 않습니다.");

        // 지원 현황 통계
        ApplicationResponse.StatusDto statusDto = applicationRepository.findSummaryByUserId(userId);

        if (statusDto == null) {
            statusDto = new ApplicationResponse.StatusDto(0L, 0L, 0L);
        }

        // 지원 현황 목록 조회
        List<ApplicationResponse.Dto> applicationDtos = applicationRepository.findApplicationsByUserId(userId);
        // respDTO에 담기
        ApplicationResponse.ListViewDTO respDTO = new ApplicationResponse.ListViewDTO(statusDto, applicationDtos);
        return respDTO;
    }
}