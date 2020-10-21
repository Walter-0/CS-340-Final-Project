package com.snhu.final_project.Controllers;
import com.snhu.final_project.Models.Stock;
import com.snhu.final_project.Models.StockUpdatePayload;
import com.snhu.final_project.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public Collection<Stock> getStocks() {
        return stockService.getStocks();
    }

    @GetMapping(value="/ticker/{ticker}")
    public Optional<Stock> getStockByTicker(@PathVariable("ticker") String ticker) {
        return stockService.getStockByTicker(ticker);
    }

    @GetMapping(value="/industry/{industry}")
    public Collection<Stock> getStocksByIndustry(@PathVariable("industry") String industry) {
        return stockService.getStocksByIndustry(industry);
    }

    @PostMapping
    public Stock postStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    @PutMapping(value="/{id}")
    public Optional<Stock> updateStockById(@PathVariable("id") String id, @RequestBody StockUpdatePayload stockUpdatePayload) {
        return stockService.updateStockById(id, stockUpdatePayload);
    }

    @DeleteMapping(value="/{id}")
    public Optional<Stock> deleteStockById(@PathVariable("id") String id) {
        return stockService.deleteStockById(id);
    }
}
