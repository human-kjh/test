package com.example.leapit.jobposting.bookmark;

import com.example.leapit.application.ApplicationResponse;
import com.example.leapit.application.bookmark.ApplicationBookmarkResponse;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public class JobPostingBookmarkResponse {
    @Data
    public static class ListDTO {
        private List<JobPostingBookmarkResponse.DTO> bookmarks;
        private ApplicationResponse.StatusDto status;

        public ListDTO(List<JobPostingBookmarkResponse.DTO> bookmarks, ApplicationResponse.StatusDto status) {
            this.bookmarks = bookmarks;
            this.status = status;
        }
    }
    @Data
    public static class DTO {
        private Integer jobPostingId;
        private String companyName;
        private String jobPostingTitle;
        private LocalDate DeadLine;

        public DTO(Integer jobPostingId, String companyName, String jobPostingTitle, LocalDate deadLine) {
            this.jobPostingId = jobPostingId;
            this.companyName = companyName;
            this.jobPostingTitle = jobPostingTitle;
            DeadLine = deadLine;
        }
    }
}
