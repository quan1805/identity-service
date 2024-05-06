package com.quandev.identityservice.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Controller
public class AuthenticationResponse {
    String token;
    boolean authenticated;
}
