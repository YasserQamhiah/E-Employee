package com.example.EEmployee.appuser.token;

import com.example.EEmployee.appuser.collection.AppUser;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Builder
@Document(collection = "Confirmation_Token")
public class ConfirmationToken
{
    @Id
    private String id;
    @NonNull
    private String token;
    @NonNull
    private LocalDateTime createdAt;
    @NonNull
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;

    @NonNull
    private AppUser appUser;
}
