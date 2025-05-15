package com.example.leapit.application;

import com.example.leapit.application.bookmark.ApplicationBookmarkResponse;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public class ApplicationResponse {

    // 지원 현황 목록 + 통계
    @Data
    public static class ListViewDTO {
        private StatusDto status;
        private List<Dto> applications;
        public ListViewDTO(StatusDto status, List<Dto> applications) {
            this.status = status;
            this.applications = applications;
        }
    }

    // 지원 현황 통계
    @Data
    public static class StatusDto {
        private Long total;
        private Long passed;
        private Long failed;

        public StatusDto(Long total, Long passed, Long failed) {
            this.total = total;
            this.passed = passed;
            this.failed = failed;
        }
    }

    // 지원 형황 목록
    @Data
    public static class Dto {
        private String companyName;
        private String jobTitle;
        private LocalDate appliedDate;
        private Integer resumeId;
        private Integer jobPostingId;
        private String result;

        public Dto(String companyName, String jobTitle, LocalDate appliedDate,
                              Integer resumeId, Integer jobPostingId, String result) {
            this.companyName = companyName;
            this.jobTitle = jobTitle;
            this.appliedDate = appliedDate;
            this.resumeId = resumeId;
            this.jobPostingId = jobPostingId;
            this.result = result;
        }
    }
}

