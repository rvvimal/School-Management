package com.School_management.controller;

import com.School_management.entity.FeePayment;
import com.School_management.service.FeePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feePayment")
public class FeePaymentController {
    @Autowired
    private FeePaymentService feePaymentService;

    @PostMapping("/create")
    private FeePayment createFeePayment(@RequestBody FeePayment feePayment) {
        return feePaymentService.saveFeePayment(feePayment);
    }

    @GetMapping("/all")
    private List<FeePayment> getAllFeePayment() {
        return feePaymentService.getAllFeePayment();
    }

    @GetMapping("/{feePaymentId}")
    private FeePayment getFeePaymentById(@PathVariable int feePaymentId) {
        return feePaymentService.findById(feePaymentId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFeePaymentById(@PathVariable Integer id) {
        return feePaymentService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public FeePayment updateById(@PathVariable("id") final Integer id, @RequestBody final FeePayment feePayment) {
        return this.feePaymentService.updateById(feePayment, id);
    }
}
