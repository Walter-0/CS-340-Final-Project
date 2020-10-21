package com.snhu.final_project.DAO;
import com.snhu.final_project.Models.Stock;
import com.snhu.final_project.Models.StockUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.Optional;

@Component
public class StockDAO {
    @Autowired
    private StockRepository repository;

    public Collection<Stock> getStocks() {
        return repository.findAll();
    }

    public Stock createStock(Stock stock) {
        return repository.insert(stock);
    }

    public Optional<Stock> getStockByTicker(String ticker) {
        return repository.findByTicker(ticker);
    }

    public Optional<Stock> deleteStockById(String id) {
        Optional<Stock> stock = repository.findById(id);
        stock.ifPresent(s -> repository.delete(s));
        return stock;
    }

    public Optional<Stock> updateStockById(String id, StockUpdatePayload stockUpdatePayload) {
        Optional<Stock> stock = repository.findById(id);
        stock.ifPresent(s -> s.setCompany(stockUpdatePayload.getCompany()));
        stock.ifPresent(s -> s.setCountry(stockUpdatePayload.getCountry()));
        stock.ifPresent(s -> s.setIndustry(stockUpdatePayload.getIndustry()));
        stock.ifPresent(s -> s.setSector(stockUpdatePayload.getSector()));
        stock.ifPresent(s -> s.setTicker(stockUpdatePayload.getTicker()));
        stock.ifPresent(s -> s.setChange(stockUpdatePayload.getChange()));
        stock.ifPresent(s -> s.setGap(stockUpdatePayload.getGap()));
        stock.ifPresent(s -> s.setPrice(stockUpdatePayload.getPrice()));
        stock.ifPresent(s -> s.setVolume(stockUpdatePayload.getVolume()));
        stock.ifPresent(s -> repository.save(s));
        return stock;
    }

    public Collection<Stock> getStocksByIndustry(String industry) {
        return repository.findTop5ByIndustry(industry);
    }
}
