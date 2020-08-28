package com.stockmarket.upload.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stockmarket.upload.helper.ExcelHelper;
import com.stockmarket.upload.model.StockPrice;
import com.stockmarket.upload.repository.StockPriceRepository;

@Service
public class ExcelService {
  @Autowired
  StockPriceRepository repository;

  public void save(MultipartFile file) {
    try {
      List<StockPrice> stock = ExcelHelper.excelToTutorials(file.getInputStream());
      repository.saveAll(stock);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

  public List<StockPrice> getAllTutorials() {
    return repository.findAll();
  }
}