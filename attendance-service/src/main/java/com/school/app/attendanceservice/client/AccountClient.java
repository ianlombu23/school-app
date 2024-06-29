package com.school.app.attendanceservice.client;

import com.school.app.attendanceservice.dto.response.StudentDetailsResponse;
import com.school.app.attendanceservice.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Component
@Slf4j
public class AccountClient {

    @Value("${client.school.account.student-details.url}")
    private String studentDetailsUrl;

    private final RestClient restClient;

    public AccountClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public StudentDetailsResponse getStudentDetail(String studentId) {
        try {
            String url = studentDetailsUrl + studentId;
            return restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(StudentDetailsResponse.class);
        } catch (HttpClientErrorException customException) {
            log.info("Get Student Detail Error, studentId : {} - {}", studentId, customException.getResponseBodyAsString());
            throw new CustomException("5000", "Get Student Detail Error", HttpStatus.CONFLICT);
        }

    }
}
