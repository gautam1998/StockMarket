package com.stockmarket.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmarket.upload.model.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
}


