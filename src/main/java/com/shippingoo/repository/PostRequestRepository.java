package com.shippingoo.repository;


import com.shippingoo.domain.PostRequest;
import com.shippingoo.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.stream.Stream;

public interface PostRequestRepository extends CrudRepository<PostRequest, Long> {

    PostRequest findByUser(User user);

    Stream<PostRequest> findAllByDateOfWorkLessThan(Date now);

  @Modifying
    @Query("delete from PostRequest t where t.dateOfWork <= ?1")
    void deleteAllExpiredSince(Date now);


}


