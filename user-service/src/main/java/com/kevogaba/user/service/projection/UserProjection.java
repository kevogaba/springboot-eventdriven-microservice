package com.kevogaba.user.service.projection;

import com.kevogaba.common.service.model.CardDetails;
import com.kevogaba.common.service.model.User;
import com.kevogaba.common.service.queries.GetUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserProjection {

    @QueryHandler
    public User getUserPaymentDetails(GetUserPaymentDetailsQuery query) {
        // Get User details from the database
        CardDetails cardDetails
                = CardDetails.builder()
                .name("Kevin Ogaba")
                .ValidUntilYear(2024)
                .validUntilMonth(12)
                .cardNumber("4478569821453697")
                .cvv(124)
                .build();

        return User.builder()
                .userId(query.getUserId())
                .firstName("Kevin")
                .lastName("Ogaba")
                .cardDetails(cardDetails)
                .build();
    }
}
