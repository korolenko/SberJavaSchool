package FinalProjectSecondService.Services.integration;

import FinalProjectSecondService.Services.integration.dto.CatalogDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogInterface {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private CatalogDto getCatalog(Long id) throws IOException {

        final ResponseEntity<String> response =
                restTemplate.getForEntity(String.format("http://localhost:8080/sparepart/%s", id), String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return objectMapper.readValue(response.getBody(), CatalogDto.class);
        } else {
            throw new RuntimeException("Error" + response.getStatusCode());
        }
    }
}
