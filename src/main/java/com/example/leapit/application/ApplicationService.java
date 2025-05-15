package com.example.leapit.application;

import com.example.leapit._core.error.ex.ExceptionApi404;
import com.example.leapit.application.bookmark.ApplicationBookmarkResponse;
import com.example.leapit.jobposting.bookmark.JobPostingBookmarkRepository;
import com.example.leapit.jobposting.bookmark.JobPostingBookmarkResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final JobPostingBookmarkRepository jobPostingBookmarkRepository;

    // 개인 마이페이지 지원 현황 관리
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

    // 개인 마이페이지 공고 스크랩 현황 관리
    public JobPostingBookmarkResponse.ListDTO myBookmarkpage(Integer userId) {
        if (userId == null) throw new Exception404("회원정보가 존재하지 않습니다.");

        // 지원 현황 통계
        ApplicationResponse.ApplicationStatusDto statusDto = applicationRepository.findSummaryByUserId(userId);

        // 스크랩한 공고 목록 조회
        List<JobPostingBookmarkResponse.DTO> bookmarkListDTO = JobPostingBookmarkRepository.findAllJobPostingBookmarkByuserId(userId);

        // respDTO에 담기
        JobPostingBookmarkResponse.ListDTO respDTO = new JobPostingBookmarkResponse.ListDTO(bookmarkListDTO, statusDto);

        return respDTO;
    }
}