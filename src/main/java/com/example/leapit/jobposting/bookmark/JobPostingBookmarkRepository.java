package com.example.leapit.jobposting.bookmark;

import com.example.leapit.application.bookmark.ApplicationBookmarkResponse;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class JobPostingBookmarkRepository {
    private final EntityManager em;

    public List<JobPostingBookmarkResponse.DTO> findAllJobPostingBookmarkByuserId(Integer userId) {
        String jpql = """
        SELECT jp.id, jp.title, jp.deadline, ci.companyName
        FROM JobPostingBookmark jb
        JOIN jb.jobPosting jp
        JOIN jp.user u
        JOIN CompanyInfo ci ON ci.user = u
        WHERE jb.user.id = :userId
        ORDER BY jp.deadline DESC
    """;

        List<Object[]> resultList = em.createQuery(jpql, Object[].class)
                .setParameter("userId", userId)
                .getResultList();

        List<JobPostingBookmarkResponse.DTO> dtos = new ArrayList<>();

        for (Object[] row : resultList) {
            Integer jobPostingId = (Integer) row[0];
            String companyName = (String) row[1];
            String title = (String) row[2];
            LocalDate deadline = (LocalDate) row[3];

            dtos.add(new JobPostingBookmarkResponse.DTO(
                    jobPostingId, companyName, title, deadline
            ));
        }

        return dtos;
    }
}
