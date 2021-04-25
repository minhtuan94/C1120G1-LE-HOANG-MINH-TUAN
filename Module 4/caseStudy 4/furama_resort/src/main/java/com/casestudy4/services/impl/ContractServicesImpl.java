package com.casestudy4.services.impl;

import com.casestudy4.entity.Contract;
import com.casestudy4.entity.ContractDetail;
import com.casestudy4.repository.ContractDetailRepository;
import com.casestudy4.repository.ContractRepository;
import com.casestudy4.services.ContractDetailServices;
import com.casestudy4.services.ContractServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class ContractServicesImpl implements ContractServices {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractDetailRepository contractDetailRepository;


    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contract.setTotalMoney(getTotalMoney(contract));
        contractRepository.save(contract);
    }

    @Override
    public void delete(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Page<Contract> getListUsingCustomer(String date, Pageable pageable) {
        return contractRepository.getListUsingCustomer(date, pageable);
    }

    @Override
    public String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    @Override
    public double getTotalMoney(Contract contract) {
        int totalDay = 0;
        double totalMoney = 0;
        double totalAttach = 0;
        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getStartDate());
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getEndDate());
            totalDay = (int) TimeUnit.DAYS.convert((end.getTime() - start.getTime()), TimeUnit.MILLISECONDS);
            if (totalDay == 0) {
                totalDay = 1; // neu startDate = endDate thi hop dong ton tai it nhat 1 ngay
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double cost = contract.getService().getCost();
        totalMoney += cost * totalDay;
        if (contract.getId() != null) {
            Set<ContractDetail> detailSet = contract.getContractDetailSet();
            if (!detailSet.isEmpty()) {
                for (ContractDetail detail : detailSet) {
                    totalAttach += detail.getAttachService().getCost() * detail.getQuantity();
                }
            }
        }
        totalMoney += totalAttach;
        return totalMoney;
    }

    @Override
    public ContractDetail save(ContractDetail contractDetail) {
        return contractDetailRepository.save(contractDetail);
    }
}
