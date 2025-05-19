package com.example.leapit.jobposting;

import com.example.leapit.common.enums.CareerLevel;
import com.example.leapit.common.region.SubRegion;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public class JobPostingResponse {

    @Data
    public static class SaveDTO {
        private List<String> positionTypes;
        private List<String> techStackCodes;
        private List<RegionDTO> regions;
        private List<CareerLevel> careerLevels;

        public SaveDTO(List<String> positionTypes, List<String> techStackCodes, List<RegionDTO> regions, List<CareerLevel> careerLevels) {
            this.positionTypes = positionTypes;
            this.techStackCodes = techStackCodes;
            this.regions = regions;
            this.careerLevels = careerLevels;
        }
    }

    @Data
    public static class RegionDTO {
        private Integer id;
        private String name;
        private List<SubRegionDTO> subRegions;

        public RegionDTO(Integer id, String name, List<SubRegion> subRegions) {
            this.id = id;
            this.name = name;
            this.subRegions = subRegions.stream()
                    .map(sr -> new SubRegionDTO(sr.getId(), sr.getName()))
                    .toList();
        }
    }

    @Data
    public static class SubRegionDTO {
        private Integer id;
        private String name;

        public SubRegionDTO(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class CareerLevelDTO {
        private CareerLevel careerLevel;

        public CareerLevelDTO(CareerLevel careerLevel) {
            this.careerLevel = careerLevel;
        }
    }

    @Data
    public static class DTO {
        private Integer id;
        private String title;
        private String positionType;
        private String minCareerLevel;
        private String maxCareerLevel;
        private String educationLevel;
        private Integer addressRegionId;
        private Integer addressSubRegionId;
        private String addressDetail;
        private String serviceIntro;
        private LocalDate deadline;
        private String responsibility;
        private String qualification;
        private String preference;
        private String benefit;
        private String additionalInfo;
        private Integer viewCount;
        private String createdAt;

        private List<String> techStacks;

        public DTO(JobPosting jobPosting) {
            this.id = jobPosting.getId();
            this.title = jobPosting.getTitle();
            this.positionType = jobPosting.getPositionType();
            this.minCareerLevel = jobPosting.getMinCareerLevel().getLabel();
            this.maxCareerLevel = jobPosting.getMaxCareerLevel().getLabel();
            this.educationLevel = jobPosting.getEducationLevel();
            this.addressRegionId = jobPosting.getAddressRegionId();
            this.addressSubRegionId = jobPosting.getAddressSubRegionId();
            this.addressDetail = jobPosting.getAddressDetail();
            this.serviceIntro = jobPosting.getServiceIntro();
            this.deadline = jobPosting.getDeadline();
            this.responsibility = jobPosting.getResponsibility();
            this.qualification = jobPosting.getQualification();
            this.preference = jobPosting.getPreference();
            this.benefit = jobPosting.getBenefit();
            this.additionalInfo = jobPosting.getAdditionalInfo();
            this.viewCount = jobPosting.getViewCount();
            this.createdAt = jobPosting.getCreatedAt().toString();
            this.techStacks = jobPosting.getJobPostingTechStacks().stream()
                    .map(jpts -> jpts.getTechStack())
                    .toList();
        }
    }
}
