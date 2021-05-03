package com.exam4.service.impl;

import com.exam4.entity.Bill;
import com.exam4.entity.Product;
import com.exam4.repository.BillRepository;
import com.exam4.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;


    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public Bill findById(Integer id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public void delete(Integer id) {
        billRepository.deleteById(id);
    }

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

//    @Override
//    public Page<Bill> getListFromTo(String from, String to, Pageable pageable) {
//        return null;
//    }
    @Override
    public double getTotalMoney(Bill bill) {
        return bill.getQuantity()*bill.getProduct().getPrice();
    }
}
