package com.kevogaba.user.service.controller;

import com.kevogaba.common.service.model.User;
import com.kevogaba.common.service.queries.GetUserPaymentDetailsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private transient QueryGateway queryGateway;

    public UserController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }


    @GetMapping("{userId}")
    public User getUserPaymentDetails(@PathVariable String userId) {
        GetUserPaymentDetailsQuery getUserPaymentDetailsQuery
                = new GetUserPaymentDetailsQuery(userId);

        User user =
                queryGateway.query(getUserPaymentDetailsQuery,
                        ResponseTypes.instanceOf(User.class)).join();

        return user;
    }
}
