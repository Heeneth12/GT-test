package com.nithin.repository;

import com.nithin.entity.vendor.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Supplier,Long> {
}
