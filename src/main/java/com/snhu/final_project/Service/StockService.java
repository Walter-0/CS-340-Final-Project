package com.snhu.final_project.Service;

import com.snhu.final_project.DAO.StockDAO;
import com.snhu.final_project.Models.Stock;
import com.snhu.final_project.Models.StockUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockDAO stockDAO;

    public Collection<Stock> getStocks() {
        return stockDAO.getStocks();
    }

    public Stock createStock(Stock stock) {
        return stockDAO.createStock(stock);
    }

    public Optional<Stock> getStockByTicker(String ticker) {
        return stockDAO.getStockByTicker(ticker);
    }

    public Optional<Stock> deleteStockById(String id) {
        return stockDAO.deleteStockById(id);
    }

    public Optional<Stock> updateStockById(String id, StockUpdatePayload stockUpdatePayload) {
        return stockDAO.updateStockById(id, stockUpdatePayload);
    }

    public Collection<Stock> getStocksByIndustry(String industry) {
        return stockDAO.getStocksByIndustry(industry);
    }
}
