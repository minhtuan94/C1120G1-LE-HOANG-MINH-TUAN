package com.casestudy4.controller;

import com.casestudy4.entity.AttachService;
import com.casestudy4.entity.Contract;
import com.casestudy4.entity.ContractDetail;
import com.casestudy4.services.AttachServiceServices;
import com.casestudy4.services.ContractDetailServices;
import com.casestudy4.services.ContractServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contract_detail")
public class ContractDetailController {

    @Autowired
    private ContractDetailServices contractDetailServices;

    @Autowired
    private AttachServiceServices attachServiceServices;

    @Autowired
    private ContractServices contractServices;

    @ModelAttribute("attachService")
    private List<AttachService> attachServiceList(){
        return attachServiceServices.findAll();
    }

    @ModelAttribute("contract")
    private List<Contract> contractList(){
        return contractServices.findAll();
    }

    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(value = 5)Pageable pageable){
        model.addAttribute("contract_detailList",contractDetailServices.findAll(pageable));
        return "contract_detail/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("createDetail", new ContractDetail());
        return "contract_detail/create";
    }

    @PostMapping("/save")
    public String save(ContractDetail contractDetail, @RequestParam(name = "contractId") Integer id){
        Contract contract = this.contractServices.findById(id);
        contractDetail.setContract(contract);
        contractDetailServices.save(contractDetail);
        contractServices.save(contract); //cập nhật lại contract tại cột total money
        return "redirect:/contract_detail/list";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        contractDetailServices.delete(id);
        return "redirect:/contract_detail/list";
    }
}
